package com.nabilaitnacer.userservice.keycloakclient;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.nabilaitnacer.userservice.dto.Role;
import com.nabilaitnacer.userservice.dto.UpdatePassword;
import com.nabilaitnacer.userservice.dto.User;
import com.nabilaitnacer.userservice.security.KeycloakSecurityUtil;
import com.nabilaitnacer.userservice.utils.Utils;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.common.util.CollectionUtil;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import jakarta.ws.rs.core.Response;


@RestController
@RequestMapping("/keycloak")
@SecurityRequirement(name = "Keycloak")
@Slf4j
public class UserResource {

    @Autowired
    KeycloakSecurityUtil keycloakUtil;

    @Value("${keycloak.realm}")
    private String realm;

    @GetMapping
    @RequestMapping("/users")
    public List<User> getUsers() {
        log.info("Getting users");
        Keycloak keycloak = keycloakUtil.getKeycloak();
        log.info("Keycloak: {}", keycloak);

        List<UserRepresentation> userRepresentations =
                keycloak.realm(realm).users().list();
        log.info("Users: {}", userRepresentations);
        return mapUsers(userRepresentations);
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakUtil.getKeycloak();

        return mapUser(keycloak.realm(realm).users().get(id).toRepresentation());
    }

    @PostMapping(value = "/user")
    public Response createUser(@RequestBody User user) {
        user.setId(Utils.generateUUID());
        UserRepresentation userRep = mapUserRep(user);
        Keycloak keycloak = keycloakUtil.getKeycloak();
        Response res = keycloak.realm(realm).users().create(userRep);
        return Response.ok(user).build();
    }

    @PutMapping(value = "/user")
    public Response updateUser(@RequestBody User user) {
        log.info("Updating user: {}", user);
        UserRepresentation userRep = mapUserRep(user);
        log.info("User representation: {}", userRep);
        Keycloak keycloak = keycloakUtil.getKeycloak();
        log.info("Keycloak: {}", keycloak);
        keycloak.realm(realm).users().get(user.getId()).update(userRep);
        return Response.ok(user).build();
    }
    @GetMapping(value = "/user/{id}/credential-types")
    public List<String> getUserCredentialTypes(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakUtil.getKeycloak();
        return keycloak.realm(realm).users().get(id).getConfiguredUserStorageCredentialTypes();
    }
    @PutMapping(value = "/user/password")
    public Response updateUserPassword(@RequestBody UpdatePassword user) {
        log.info("Updating password for user: {}", user);
        Keycloak keycloak = keycloakUtil.getKeycloak();
        UserRepresentation userRep = keycloak.realm(realm).users().get(user.getId()).toRepresentation();
        log.info("User representation: {}", userRep.getCredentials());

        // Get the current password from Keycloak
        List<CredentialRepresentation> currentCredentials = userRep.getCredentials();
        String currentPassword = currentCredentials.stream()
                .filter(cred -> cred.getType().equals("password"))
                .findFirst()
                .map(CredentialRepresentation::getValue)
                .orElse(null);

        // Check if the sent password matches the current password
        if (user.getPassword().equals(currentPassword)) {
            // Update the password
            CredentialRepresentation newCred = new CredentialRepresentation();
            newCred.setType(CredentialRepresentation.PASSWORD);
            newCred.setValue(user.getNewPassword());
            newCred.setTemporary(false);
            userRep.setCredentials(Arrays.asList(newCred));

            keycloak.realm(realm).users().get(user.getId()).update(userRep);
            log.info("Password updated for user: {}", user);
            return Response.ok(user).build();
        } else {
            log.info("Sent password does not match the current password for user: {}", user);
            return Response.status(Response.Status.BAD_REQUEST).entity("Sent password does not match the current password").build();
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public Response deleteUser(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakUtil.getKeycloak();
        keycloak.realm(realm).users().delete(id);
        return Response.ok().build();
    }

    @GetMapping(value = "/users/{id}/roles")
    public List<Role> getRoles(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakUtil.getKeycloak();
        return RoleResource.mapRoles(keycloak.realm(realm).users()
                .get(id).roles().realmLevel().listAll());
    }

    @PostMapping(value = "/users/{id}/roles/{roleName}")
    public Response createRole(@PathVariable("id") String id,
                               @PathVariable("roleName") String roleName) {
        Keycloak keycloak = keycloakUtil.getKeycloak();
        RoleRepresentation role = keycloak.realm(realm).roles().get(roleName).toRepresentation();
        keycloak.realm(realm).users().get(id).roles().realmLevel().add(Arrays.asList(role));
        return Response.ok().build();
    }

    private List<User> mapUsers(List<UserRepresentation> userRepresentations) {
        List<User> users = new ArrayList<>();
        if(CollectionUtil.isNotEmpty(userRepresentations)) {
            userRepresentations.forEach(userRep ->
                users.add(mapUser(userRep))
            );
        }
        return users;
    }

    private User mapUser(UserRepresentation userRep) {
        User user = new User();
        user.setId(userRep.getId());
        user.setFirstName(userRep.getFirstName());
        user.setLastName(userRep.getLastName());
        user.setEmail(userRep.getEmail());
        user.setUserName(userRep.getUsername());

        return user;
    }

    private UserRepresentation mapUserRep(User user) {
        UserRepresentation userRep = new UserRepresentation();
        userRep.setId(user.getId());
        userRep.setUsername(user.getUserName());
        userRep.setFirstName(user.getFirstName());
        userRep.setLastName(user.getLastName());
        userRep.setEmail(user.getEmail());
        userRep.setEnabled(true);
        userRep.setEmailVerified(true);
        List<CredentialRepresentation> creds = new ArrayList<>();
        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setTemporary(false);
        cred.setValue(user.getPassword());
        creds.add(cred);
        userRep.setCredentials(creds);
        return userRep;
    }

}
