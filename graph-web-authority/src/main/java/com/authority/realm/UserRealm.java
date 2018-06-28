package com.authority.realm;

import com.authority.jpa.entity.User;
import com.authority.jpa.repository.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserRepository userRepository;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws
            AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();
        User user = userRepository.findByUserName(loginName);
        if (user == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String currentLoginName = (String) principalCollection.getPrimaryPrincipal();
        User user = userRepository.findByUserName(currentLoginName);

        List<String> userRoles = new ArrayList<>();
        List<String> userPermissions = new ArrayList<>();
//        userPermissions.add("ACTUATOR");
//        userRoles.add("ACTUATOR");
//        if (null != user) {
//          get all role
//            List<Role> roles = roleService.findByUserId(user.getId());
//            for (int i = 0; i < roles.size(); i++) {
//                userRoles.add(roles.get(i).getCode());
//            }
//        } else {
//            throw new AuthorizationException();
//        }
        // set roles and permissions
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(userRoles);
        authorizationInfo.addStringPermissions(userPermissions);
        return authorizationInfo;
    }
}
