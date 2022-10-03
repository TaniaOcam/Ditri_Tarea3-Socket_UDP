package py.una.pol.distritarea3.Models;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alejandra Lezcano https://github.com/lezcanoale
 */
public class Mensaje {

    public int tipo_operacion;
    public String cuerpo;

    public Mensaje(int tipo_operacion, String cuerpo) {
        this.tipo_operacion = tipo_operacion;
        this.cuerpo = cuerpo;
    }

    public Mensaje(String JSON) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(JSON.trim());
        JSONObject jsonObject = (JSONObject) obj;

        this.tipo_operacion = (int) (long) jsonObject.get("tipo_operacion");
        this.cuerpo = (String) jsonObject.get("cuerpo");
    }

    public String toJSON() {
        JSONObject obj = new JSONObject();

        obj.put("tipo_operacion", tipo_operacion);
        obj.put("cuerpo", cuerpo);

        return obj.toJSONString();
    }
}
