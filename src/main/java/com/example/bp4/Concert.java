package com.example.bp4;

public class Concert extends Voorstelling {
    private Integer concertID;
    private String concert;
    private String artiest;

    @Override
    public Integer getConcertID() {
        return concertID;
    }

    @Override
    public void setConcertID(Integer concertID) {
        this.concertID = concertID;
    }

    public String getConcert() {
        return concert;
    }

    public void setConcert(String concert) {
        this.concert = concert;
    }

    public String getArtiest() {
        return artiest;
    }

    public void setArtiest(String artiest) {
        this.artiest = artiest;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private String genre;
}
