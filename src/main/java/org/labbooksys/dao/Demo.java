package org.labbooksys.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.labbooksys.entity.Teacher;

public class Demo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Teacher t = mapper.readValue("{\"mtId\":\"T2101\",\"mtName\":\"fsdfsf\",\"mtPhone\":\"fsdfs\",\"mtEmail\":\"dfsdfsd\",\"tcDeft\":\"fdsdsf\",\"tProject\":\"fsdfsdf\",\"tClasses\":\"fdsfsd\"}", Teacher.class);
        System.out.println(t.toString());
    }
}
