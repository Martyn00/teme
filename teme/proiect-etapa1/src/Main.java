import Input.Data;
import Others.All;
import Output.Output;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Data data;
        data = objectMapper.readValue(new File(args[0].toString()), Data.class);
        All all = new All(data);
        Output output = all.doALl();
        objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[1].toString()), output);
        System.out.println(args[1].toString());
    }
}
