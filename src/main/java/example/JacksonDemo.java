package example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class User{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class JacksonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String serialized = "{ \"name\": \"Ola\", \"age\": 27}";
        User user = mapper.readValue( serialized, User.class);
        JsonNode jsonNode = mapper.readTree(serialized);
        System.out.println(user);
        System.out.println(jsonNode.get("name"));
        System.out.println(jsonNode.get("age"));
    }
}
