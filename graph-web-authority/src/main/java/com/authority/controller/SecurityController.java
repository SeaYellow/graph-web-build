package com.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.authority.enumUtil.AuthorityActionEnum;
import com.authority.enumUtil.AuthorityErrorCodeEnum;
import com.common.utils.ConstantUtil;
import com.common.utils.ResponseStatus;
import com.common.utils.Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/14.
 */
@RestController
@RequestMapping("authority")
public class SecurityController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public JSONObject login() {
        JSONObject res = new JSONObject();
        res.put(ConstantUtil.STATUS, ResponseStatus.OK.value());
        res.put(ConstantUtil.ACTION, AuthorityActionEnum.LOGIN.getValue());
        res.put(ConstantUtil.MSG, ConstantUtil.SUCCESS);
        return res;
    }

    @RequestMapping("/loginValidate")
    public JSONObject loginValidate(@RequestParam(value = "userName") String userName, @RequestParam(value = "passWord") String passWord) {
        JSONObject res = new JSONObject();
        if (Util.isEmpty(userName) || Util.isEmpty(passWord)) {
            res.put(ConstantUtil.STATUS, ResponseStatus.FAILED.value());
            res.put(ConstantUtil.ERROR_CODE, AuthorityErrorCodeEnum.USER_PASSWORD_EMPTY.getCode());
            res.put(ConstantUtil.MSG, AuthorityErrorCodeEnum.USER_PASSWORD_EMPTY.getErrorMsg());
            return res;
        }
        logger.info("login userName : " + userName);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            logger.info(userName + " authentication start.");
            currentUser.login(token);
            logger.info(userName + " authentication success.");
        } catch (UnknownAccountException uae) {
            res.put(ConstantUtil.ERROR_CODE, AuthorityErrorCodeEnum.UNKNOWN_ACCOUNT.getCode());
            res.put(ConstantUtil.MSG, AuthorityErrorCodeEnum.UNKNOWN_ACCOUNT.getErrorMsg());
            logger.info(userName + " UnknownAccountException.");
        } catch (IncorrectCredentialsException ice) {
            res.put(ConstantUtil.ERROR_CODE, AuthorityErrorCodeEnum.INCORRECT_CREDENTIALS.getCode());
            res.put(ConstantUtil.MSG, AuthorityErrorCodeEnum.INCORRECT_CREDENTIALS.getErrorMsg());
            logger.info(userName + " IncorrectCredentialsException.");
        } catch (LockedAccountException lae) {
            res.put(ConstantUtil.ERROR_CODE, AuthorityErrorCodeEnum.LOCKED_ACCOUNT.getCode());
            res.put(ConstantUtil.MSG, AuthorityErrorCodeEnum.LOCKED_ACCOUNT.getErrorMsg());
            logger.info(userName + " LockedAccountException.");
        } catch (ExcessiveAttemptsException eae) {
            res.put(ConstantUtil.ERROR_CODE, AuthorityErrorCodeEnum.EXCESSIVE_ATTEMPTS.getCode());
            res.put(ConstantUtil.MSG, AuthorityErrorCodeEnum.EXCESSIVE_ATTEMPTS.getErrorMsg());
            logger.info(userName + " ExcessiveAttemptsException.");
        } catch (AuthenticationException ae) {
            res.put(ConstantUtil.ERROR_CODE, AuthorityErrorCodeEnum.AUTHENTICATION_ERROR.getCode());
            res.put(ConstantUtil.MSG, AuthorityErrorCodeEnum.AUTHENTICATION_ERROR.getErrorMsg());
            logger.error(userName + " AuthenticationException.", ae);
        }
        if (currentUser.isAuthenticated()) {
            logger.info(userName + " Authentication Success.");
            res.put(ConstantUtil.STATUS, ResponseStatus.OK.value());
            res.put(ConstantUtil.ACTION, AuthorityActionEnum.LOGIN_VALIDATE.getValue());
            res.put(ConstantUtil.MSG, ConstantUtil.SUCCESS);
        } else {
            token.clear();
            res.put(ConstantUtil.STATUS, ResponseStatus.FAILED.value());
        }
        return res;
    }

    @RequestMapping("/logout")
    public JSONObject logout() {
        JSONObject res = new JSONObject();
        SecurityUtils.getSubject().logout();
        res.put(ConstantUtil.STATUS, ResponseStatus.OK.value());
        res.put(ConstantUtil.ACTION, AuthorityActionEnum.LOGOUT.getValue());
        res.put(ConstantUtil.MSG, ConstantUtil.SUCCESS);
        return res;
    }

    @RequestMapping("/403")
    public JSONObject unauthorized() {
        logger.info("unauthorized.");
        JSONObject res = new JSONObject();
        res.put(ConstantUtil.STATUS, ResponseStatus.OK.value());
        res.put(ConstantUtil.ACTION, AuthorityActionEnum.UNAUTHORIZED.getValue());
        res.put(ConstantUtil.MSG, ConstantUtil.SUCCESS);
        return res;
    }
}
