package com.ubivelox.tlv.domain;

import lombok.Data;

@Data
public class Tlv {
    private String tag;
    private String length;
    private String value;
}
