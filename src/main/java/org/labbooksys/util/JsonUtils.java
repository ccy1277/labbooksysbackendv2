package org.labbooksys.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.ResultInfo;
import org.labbooksys.entity.User;

public class JsonUtils {
    public static String toJsonString(ResultInfo resultInfo) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(resultInfo);
    }
    public static String toJsonString(User user) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(user);
    }
    public static User toUserObject(String str) throws JsonProcessingException {
        return new ObjectMapper().readValue(str, User.class);
    }
}
