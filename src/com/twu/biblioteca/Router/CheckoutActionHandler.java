package com.twu.biblioteca.Router;

import com.twu.biblioteca.Service.LibraryService;

/**
 * Created by xuewang on 8/1/16.
 */
public class CheckoutActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;

    public CheckoutActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }
    @Override
    public RouterMessage handle(String userInput) {
        boolean checkoutSuccess = m_libraryService.checkoutBook(userInput);
        m_routerContext.setNextState(RouterState.MainMenu);
        if (checkoutSuccess)
        {
            return new RouterMessage(false, "Thank you! Enjoy the book.\n", false);
        }
        return new RouterMessage(false, "That book is not available.\n", false);
    }
}
