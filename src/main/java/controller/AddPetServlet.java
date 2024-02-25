package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPet;

/**
 * Servlet implementation class AddPetServlet
 */
@WebServlet("/addPetServlet")
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
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
		String species = request.getParameter("species");
        String gender = request.getParameter("gender");
        String ageParam = request.getParameter("age");
        int age = 0;

        if (species.isEmpty() || gender.isEmpty() || species == null || gender == null || ageParam == null) {
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        } else {
            age = Integer.parseInt(ageParam);
            ListPet petToAdd = new ListPet(species, gender, age);
            ListPetHelper petHelper = new ListPetHelper();
            petHelper.insertPet(petToAdd);
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        }
	}

}
