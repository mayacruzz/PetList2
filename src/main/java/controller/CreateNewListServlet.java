package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListPet;
import model.Shopper;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListPetHelper lih = new ListPetHelper();
        String listName = request.getParameter("listName");

        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String year = request.getParameter("year");

        String shopperName = request.getParameter("shopperName");

        LocalDate ld;
        try {
            ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (NumberFormatException ex) {
            ld = LocalDate.now();
        }

        String[] selectedListPets = request.getParameterValues("allListPetsToAdd");
        List<ListPet> selectedPetsInList = new ArrayList<>();
        // Make sure something was selected – otherwise, we get a null pointer exception
        if (selectedListPets != null && selectedListPets.length > 0) {
            for (int i = 0; i < selectedListPets.length; i++) {
                ListPet listPet = lih.searchForPetById(Integer.parseInt(selectedListPets[i]));
                selectedPetsInList.add(listPet);
            }
        }

        Shopper shopper = new Shopper(shopperName);
        ListDetails sld = new ListDetails(listName, ld, shopper);
        sld.setListOfListPets(selectedPetsInList);
        ListDetailsHelper slh = new ListDetailsHelper();
        slh.insertNewListDetails(sld);

        System.out.println("Success!");
        System.out.println(sld.toString());

        getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
