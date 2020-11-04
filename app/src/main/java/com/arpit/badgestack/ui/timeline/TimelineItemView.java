package com.arpit.badgestack.ui.timeline;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class TimelineItemView  {
    String itemName;
    int color;

    public TimelineItemView(String itemName , int color) {
        this.itemName = itemName;
        this.color = color;
    }

    public String getItemName() {
        return itemName;
    }
    public int getColor()
    {
        return color;
    }
}
