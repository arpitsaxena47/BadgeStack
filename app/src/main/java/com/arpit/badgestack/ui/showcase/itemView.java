package com.arpit.badgestack.ui.showcase;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public class itemView {
    String imageUrl;
    String badgeName;
    String companyName;
    String dateOfIssue;

    public itemView(String imageUrl , String badgeName, String companyName, String dateOfIssue) {
        this.imageUrl = imageUrl;
        this.badgeName = badgeName;
        this.companyName = companyName;
        this.dateOfIssue = dateOfIssue;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
