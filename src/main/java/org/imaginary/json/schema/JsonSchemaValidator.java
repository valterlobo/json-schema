package org.imaginary.json.schema;

import java.util.ArrayList;
import java.util.List;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;


public class JsonSchemaValidator {

    public static List<String> validator(String schemaRaw, String jsonRaw) {
        
        Schema schema = JsonSchemaValidator.getSchema(schemaRaw);
        List<String> violations = new ArrayList<String>();
        try {

            JSONObject jsonOBJ = new JSONObject(jsonRaw);
            schema.validate(jsonOBJ);
        
        } catch (ValidationException e) {

            violations = e.getAllMessages();
        } catch (org.json.JSONException exJSON) {

            violations.add(exJSON.getMessage());

        }
        return violations;
        
    }


    private static Schema getSchema(String schemaRaw) {

        Schema schema;

        try {
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaRaw));
            schema = SchemaLoader.load(rawSchema);

        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

        return schema;
    }
}