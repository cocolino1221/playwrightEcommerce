package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginPage {
    public static final String HOMEPAGE_URL = "https://www.saucedemo.com/";
    public static void main(String[] args) {



        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate(HOMEPAGE_URL);
    }
}}