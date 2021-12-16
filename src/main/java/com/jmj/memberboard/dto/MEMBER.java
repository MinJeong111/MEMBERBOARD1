package com.jmj.memberboard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Data
@Alias("member")
public class MEMBER {
    String mId;
    String mPw;
    String mName;
    String mAge;
    String mBirth;
    String mPhone;
    String mAddress;
    MultipartFile mProfile;
    String mProfileName;

    String address1;
    String address2;
    String address3;
}
