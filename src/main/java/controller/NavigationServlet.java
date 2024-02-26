package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPet;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListPetHelper dao = new ListPetHelper();
        String act = request.getParameter("doThisToListPet");

        // After all changes, we should redirect to the viewAllListPets servlet
        // The only time we don't is if they select to add a new ListPet or edit

        String path = "/viewAllListPetsServlet";

        if (act.equals("delete")) {
            try {
                Integer tempId = Integer.parseInt(request.getParameter("id"));
                ListPet petToDelete = dao.searchForPetById(tempId);
                dao.deletePet(petToDelete);
            } catch (NumberFormatException e) {
                System.out.println("Forgot to select a ListPet");
            }
        } else if (act.equals("edit")) {
            try {
                Integer tempId = Integer.parseInt(request.getParameter("id"));
                ListPet petToEdit = dao.searchForPetById(tempId);
                request.setAttribute("listPetToEdit", petToEdit);
                path = "/edit-list-pet.jsp";
            } catch (NumberFormatException e) {
                System.out.println("Forgot to select a ListPet");
            }
        } else if (act.equals("add")) {
            path = "/index.html";
        }
        getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
