package com.ubivelox.tlv.domain;

import com.ubivelox.tlv.common.ConstantCode.DataObjectType;
import com.ubivelox.tlv.common.ConstantCode.TagValueType;

public interface Tag {

    public enum TagClass {
	UNIVERSAL, APPLICATION, CONTEXT_SPECIFIC, PRIVATE
    }

    boolean isConstructed();

    String getTag();

    String getName();

    String getDescription();

    DataObjectType getDataObjectType();

    TagValueType getTagValueType();

    TagClass getTagClass();

    int getNumTagBytes();
}
