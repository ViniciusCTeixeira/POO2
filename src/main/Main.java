package main;

import Tools.DatabaseConnection;
import Users.UserPages;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserPages pages = new UserPages();
        pages.StartPage();
    }
}
