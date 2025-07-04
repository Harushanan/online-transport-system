package com.Bookings;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class BookingSuccessServlet
 */
@WebServlet("/BookingSuccessServlet")
public class BookingSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = null;
		HttpSession session = request.getSession(false);
	    if (session != null) {
		    // Retrieve a session variable (for example, "userName")
		    username = (String) session.getAttribute("userName");
		}
		
		BookingDao bookDao = new BookingDao();
		try {
			String DriverDetail = bookDao.displayDriver(username);
			request.setAttribute("DriverDetail", DriverDetail);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		 request.getRequestDispatcher("BookingSuccess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
