package ru.itis.socialnetworkboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MapDto {

    private String lat;
    private String lon;

    public MapDto(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

}
