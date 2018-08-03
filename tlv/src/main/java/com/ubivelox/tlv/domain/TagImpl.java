package com.ubivelox.tlv.domain;

import com.ubivelox.tlv.common.ConstantCode;
import com.ubivelox.tlv.common.ConstantCode.DataObjectType;
import com.ubivelox.tlv.common.ConstantCode.TagValueType;
import com.ubivelox.tlv.common.HexUtil;

public final class TagImpl implements Tag {

    private final byte[]	 tagBytes;
    public final String		 name;
    private final String	 description;
    private final TagValueType	 tagValueType;
    private final TagClass	 tagClass;
    private final DataObjectType type;

    public TagImpl(final String tag, final TagValueType tagValueType, final String name, final String description) {
	this(HexUtil.convertHexStringToByte(tag), tagValueType, name, description);
    }

    public TagImpl(final byte[] tagBytes, final TagValueType tagValueType, final String name,
	    final String description) {
	if (tagBytes == null) {
	    throw new IllegalArgumentException("Param id cannot be null");
	}
	if (tagBytes.length == 0) {
	    throw new IllegalArgumentException("Param id cannot be empty");
	}
	if (tagValueType == null) {
	    throw new IllegalArgumentException("Param tagValueType cannot be null");
	}
	this.tagBytes = tagBytes;
	this.name = name;
	this.description = description;
	this.tagValueType = tagValueType;

	// Tag Byte Array 변환 후 계산
	// byte[] tagByte = HexUtil.convertHexStringToByte(id);

	if ((tagBytes[0] & ConstantCode.TAG.CONSTRUCTED_DATAOBJECT) == ConstantCode.TAG.CONSTRUCTED_DATAOBJECT) {
	    type = DataObjectType.CONSTRUCTED;
	} else { // 원시데이터 처리
	    type = DataObjectType.PRIMITIVE;
	}

	if ((tagBytes[0] & ConstantCode.TAG.PRIVATE_CLASS) == ConstantCode.TAG.PRIVATE_CLASS) {
	    tagClass = TagClass.PRIVATE;
	} else if ((tagBytes[0] & ConstantCode.TAG.CONTEXT_SPECIFIC_CLASS) == ConstantCode.TAG.CONTEXT_SPECIFIC_CLASS) {
	    tagClass = TagClass.CONTEXT_SPECIFIC;
	} else if ((tagBytes[0] & ConstantCode.TAG.APPLICATION_CLASS) == ConstantCode.TAG.APPLICATION_CLASS) {
	    tagClass = TagClass.APPLICATION;
	} else {
	    tagClass = TagClass.UNIVERSAL;
	}
    }

    @Override
    public boolean isConstructed() {
	return type == DataObjectType.CONSTRUCTED;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getDescription() {
	return description;
    }

    @Override
    public TagClass getTagClass() {
	return tagClass;
    }

    @Override
    public DataObjectType getDataObjectType() {
	return type;
    }

    @Override
    public TagValueType getTagValueType() {
	return tagValueType;
    }

    @Override
    public byte[] getTagByte() {
	return tagBytes;
    }

    @Override
    public int getTagBytes() {
	return tagBytes.length;
    }

}
