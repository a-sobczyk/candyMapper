package org.candyMapper.helpers.enums;

public enum County {
    AVON("Avon"),
    BEDFORDSHIRE("Bedfordshire"),
    BERKSHIRE("Berkshire"),
    BRISTOL("Bristol"),
    CAMBRIDGESHIRE("Cambridgeshire"),
    CORNWALL("Cornwall"),
    CUMBRIA("Cumbria"),
    DERBYSHIRE("Derbyshire"),
    DEVON("Devon"),
    DORSET("Dorset"),
    DURHAM("Durham"),
    EAST_YORKSHIRE("East Yorkshire"),
    EAST_SUSSEX("East Sussex"),
    ESSEX("Essex"),
    GLOUCESTERSHIRE("Gloucestershire"),
    GREATER_LONDON("Greater London"),
    GREATER_MANCHESTER("Greater Manchester"),
    HAMPSHIRE("Hampshire"),
    HEREFORDSHIRE("Herefordshire"),
    HERTFORDSHIRE("Hertfordshire"),
    ISLE_OF_WIGHT("Isle of Wight"),
    KENT("Kent"),
    LANCASHIRE("Lancashire"),
    LEICESTERSHIRE("Leicestershire"),
    LINCOLNSHIRE("Lincolnshire"),
    CITY_OF_LONDON("City of London"),
    MERSEYSIDE("Merseyside"),
    NORFOLK("Norfolk"),
    NORTHAMPTONSHIRE("Northamptonshire"),
    NORTHUMBERLAND("Northumberland"),
    NORTH_YORKSHIRE("North Yorkshire"),
    NOTTINGHAM("Nottingham"),
    OXFORDSHIRE("Oxfordshire"),
    RUTLAND("Rutland"),
    RHODE_ISLAND("Rhode Island"),
    SHROPSHIRE("Shropshire"),
    SOMERSET("Somerset"),
    SOUTH_YORKSHIRE("South Yorkshire"),
    STAFFORDSHIRE("Staffordshire"),
    SUFFOLK("Suffolk"),
    SURREY("Surrey"),
    TYNE_AND_WEAR("Tyne and Wear"),
    WARWICKSHIRE("Warwickshire"),
    WEST_MIDLANDS("West Midlands"),
    WEST_SUSSEX("West Sussex"),
    WEST_YORKSHIRE("West Yorkshire"),
    WILTSHIRE("Wiltshire"),
    WORCESTERSHIRE("Worcestershire");

    private final String county;

    County(String county) {
        this.county = county;
    }

    public String getText() {
        return this.county;
    }
}
