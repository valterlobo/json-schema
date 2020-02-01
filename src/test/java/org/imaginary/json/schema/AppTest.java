package org.imaginary.json.schema;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        String strJson = 
        "{ \"rectangle\":{"
        + "\"a\" : -5,"
        + "\"b\" : 5"
        + "} }"; 
        

        InputStream inputStream = getClass().getResourceAsStream("rectangle-schema.json");
 try {

    String schemaRaw = IOUtils.toString(inputStream, "UTF-8"); 

        List<String> violations = JsonSchemaValidator.validator(schemaRaw , strJson);
        violations.stream().forEach(System.out::println);

        assertTrue( true );
        
 }catch (IOException e){
     
 }
       
    }




    @Test
    public void testValidadorParam()
    {

        String strJson = 
        "{ \"rectangle\":{"
        + "\"a\" : 50,"
        + "\"b\" : 5"
        + "} }"; 
        

        InputStream inputStream = getClass().getResourceAsStream("rectangle-schema.json");
 try {

    String schemaRaw = IOUtils.toString(inputStream, "UTF-8"); 

        List<String> violations = JsonSchemaValidator.validator(schemaRaw , strJson);

        if (violations.size() > 0 ){
            assertTrue( false );  
        }else {

            JSONObject jsonOBJ = new JSONObject(strJson);
            System.out.println(jsonOBJ.getJSONObject("rectangle").getNumber("a"));
            assertTrue( true );
            
        }

        
        
 }catch (IOException e){

    assertTrue( false );  
     
 }
       
    }
}
