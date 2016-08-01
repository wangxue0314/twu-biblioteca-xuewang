package com.twu.biblioteca.Router;

import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Book;

import java.util.ArrayList;

/**
 * Created by xuewang on 8/1/16.
 */
public class MainMenuActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;
    private static String MainMenuText = "********MainMenu************\n"
            + "****************************\n"
            + "1. List Books\n";

    public MainMenuActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }

    public String GetBookDetails(){
        ArrayList<Book> unCheckBook = m_libraryService.ListBooks();
        String booksDetails = "";
        for(int i=0; i<unCheckBook.size(); i++){
            booksDetails += (unCheckBook.get(i).getBookName() + "," + unCheckBook.get(i).getBookAuthor() + "," + unCheckBook.get(i).getBookYear() + "\n");
        }
        return booksDetails;
    }

    @Override
    public RouterMessage Handle(String userInput)
    {
        if (userInput.equals("")) {
            return new RouterMessage(false, MainMenuText, false);
        } else if (userInput.equals("1")) {
            return new RouterMessage(false, GetBookDetails() + MainMenuText, false);
        }
        else if(userInput.equals("2")){
            return new RouterMessage(false, null, true);
        } else if(userInput.equals("4")){
            return new RouterMessage(true, "", false);
        }
        else {
            return new RouterMessage(false, "Select a valid option!\n" + MainMenuText, false);
        }
    }
}