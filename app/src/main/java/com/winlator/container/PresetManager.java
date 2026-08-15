package com.winlator.container;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PresetManager {

    // Função que lê o presets.json da pasta assets do celular
    public static List<Preset> loadPresets(Context context) {
        List<Preset> presets = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open("presets.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            
            String jsonStr = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(jsonStr);
            
            for (int i = 0; i < jsonArray.length(); i++) {
                presets.add(new Preset(jsonArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return presets;
    }

    // Função mágica que aplica o perfil escolhido direto no Container do usuário!
    public static void applyPreset(Container container, Preset preset) {
        if (preset.getResolution() != null && !preset.getResolution().isEmpty()) {
            container.setScreenSize(preset.getResolution());
        }
        
        if (preset.getGraphicsDriver() != null && !preset.getGraphicsDriver().isEmpty()) {
            container.setGraphicsDriver(preset.getGraphicsDriver());
        }
        
        if (preset.getDxvkVersion() != null && !preset.getDxvkVersion().isEmpty()) {
            container.setDXWrapper(preset.getDxvkVersion());
        }
        
        if (preset.getWineVersion() != null && !preset.getWineVersion().isEmpty()) {
            container.setWineVersion(preset.getWineVersion());
        }
    }
}
