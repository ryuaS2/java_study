package com.ubivelox.tlv.domain;

import lombok.Data;

@Data
public class Tlv {
    private String tag;
    private int	   length;
    private String value;
}
