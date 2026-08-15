package com.winlator.container;

import org.json.JSONException;
import org.json.JSONObject;

public class Preset {
    private final String id;
    private final String name;
    private final String resolution;
    private final String graphicsDriver;
    private final String dxvkVersion;
    private final String wineVersion;
    private final String description;

    public Preset(JSONObject json) throws JSONException {
        this.id = json.getString("id");
        this.name = json.getString("name");
        this.resolution = json.getString("resolution");
        this.graphicsDriver = json.getString("graphics_driver");
        this.dxvkVersion = json.getString("dxvk_version");
        this.wineVersion = json.getString("wine_version");
        this.description = json.optString("description", "");
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getResolution() { return resolution; }
    public String getGraphicsDriver() { return graphicsDriver; }
    public String getDxvkVersion() { return dxvkVersion; }
    public String getWineVersion() { return wineVersion; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name;
    }
}
