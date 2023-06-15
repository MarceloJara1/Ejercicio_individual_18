package com.example.ejercicioindividual18;

public class ImageItem {
    private String imageUrl;
    private String description;
    private String nombre;

    public ImageItem(String imageUrl, String description, String nombre) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.nombre = nombre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getNombre(){
        return  nombre;
    }


}
