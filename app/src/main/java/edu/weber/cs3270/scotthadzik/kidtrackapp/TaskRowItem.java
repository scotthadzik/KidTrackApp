package edu.weber.cs3270.scotthadzik.kidtrackapp;

/**
 * Created by Joe on 6/27/2015.
 */
public class TaskRowItem {private String title;
    private int icon;

    public TaskRowItem(String title, int icon) {
        this.title = title;
        this.icon = icon;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}