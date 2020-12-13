/*
 * Алгоритм создания Web приложения на Java
 * 
 * 1. Создать WebApplication в NetBeans
 * 2. Создать сущностные классы c аннотациями в пакете entity раздела Source Packages
 * 3. Создать базу данных и настроить persistence.xml.
 * 4. Создать сессионные Java Enterprice Beans для каждого сущностного класса 
 *    с помощью помощника NetBeans
 * 5. Создать странички jsp в разделе Web Pages (/web). 
 *    Обязательная папка WEB-INF служит для сокрытия ресурсов от прямого доступа
 * 6. Создать сервлет "MyServlet" в пакете servlets раздела Source Packages.
 * 7. Настроить параметр аннотации @WebServlet(urlPatterns={...})
 *    При запросе от клиента содержащего эти параметры будет выполняться метод
 *    ProcessRequest сервлета "MyServlet", который управляется веб контейнером
 * 8. Получить текущий запрос из запроса "path"
 * 9. Обработать запрос в switch и с помощью метода getRequestDispatcher()
 *    отдать страничку jsp с данными клиенту. 
 *    Например:
 *    request.getRequestDispatcher("/WEB-INF/addBookForm.jsp").forward(request, response);
 * 10. Для получения объектов классов "фасадов" использовать аннотацию @EJB 
 *    в поле класса "MyServlet"
 *
 */
package servlets;

import entity.Furniture;
import entity.History;
import entity.Buyer;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.FurnitureFacade;
import session.BuyerFacade;
import session.HistoryFacade;
import session.BuyerFacade;
/**
 * @author Juri
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/addFurniture",
    "/createFurniture",
    "/listFurnitures",
    "/addBuyer",
    "/createBuyer",
    "/listBuyers",
    "/takeOnFurnitureForm",
    "/takeOnFurniture",
    "/returnFurnitureForm",
    "/returnFurniture",
    
    
})
public class MyServlet extends HttpServlet {
@EJB
private FurnitureFacade furnitureFacade;
@EJB
private BuyerFacade buyerFacade;
@EJB
private HistoryFacade historyFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path){
            case "/addFurniture":
                request.getRequestDispatcher("/WEB-INF/addFurnitureForm.jsp").forward(request, response);
                break;
            case "/createFurniture":
                String name = request.getParameter("name");
                String color = request.getParameter("color");
                String size = request.getParameter("size");
                String publishedYear = request.getParameter("publishedYear");
                if ("".equals(name) || name == null
                        || "".equals(color) || color == null
                        || "".equals(size) || size == null
                        || "".equals(publishedYear) || publishedYear == null){
                    request.setAttribute("name", name);
                    request.setAttribute("color", color);
                    request.setAttribute("size", size);
                    request.setAttribute("publishedYear", publishedYear);
                    request.setAttribute("info", "Fill in all the fields.");
                    request.getRequestDispatcher("/WEB-INF/addFurnitureForm.jsp").forward(request, response); 
                    break;
                }
                Furniture furniture = new Furniture(name, color, size, publishedYear);
                furnitureFacade.create(furniture);
                request.setAttribute("info", "Furniture\"" +furniture.getName()+ "\" have been added");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "/listFurnitures":
                List<Furniture> listFurnitures = furnitureFacade.findAll();
                request.setAttribute("listFurnitures", listFurnitures);
                request.getRequestDispatcher("listFurnitures.jsp").forward(request, response);
                break; 
            case "/addBuyer":
                request.getRequestDispatcher("/WEB-INF/addBuyerForm.jsp").forward(request, response);
                break;
            case "/createBuyer":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                String wallet = request.getParameter("wallet");
                
                if ("".equals(firstname) || firstname == null
                        || "".equals(lastname) || lastname == null
                        || "".equals(phone) || phone == null
                        || "".equals(wallet) || wallet == null){
                    request.setAttribute("firstname", firstname);
                    request.setAttribute("lastname", lastname);
                    request.setAttribute("phone", phone);
                    request.setAttribute("wallet", wallet);
                    
                    request.setAttribute("info", "Fill in all the fields.");
                    request.getRequestDispatcher("/WEB-INF/addBuyerForm.jsp").forward(request, response); 
                    break;
                }
                Buyer buyer = new Buyer(firstname, lastname, phone, wallet);
                buyerFacade.create(buyer);
                request.setAttribute("info", "Buyer\"" +buyer.getFirstname()+" " +buyer.getLastname()+ "\" have been added");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "/listBuyers":
                List<Buyer> listBuyers = buyerFacade.findAll();
                request.setAttribute("listBuyers", listBuyers);
                request.getRequestDispatcher("listBuyers.jsp").forward(request, response);
                break;
            case "/takeOnFurnitureForm":
                listFurnitures = furnitureFacade.findAll();
                request.setAttribute("listFurnitures", listFurnitures);
                listBuyers = buyerFacade.findAll();
                request.setAttribute("listBuyers", listBuyers);
                //-------------------emptying the buyers wallet------------------
//                Furniture furniture = new Furniture();
//                Buyer buyer = new Buyer();
//                    int wallet = buyer.getWallet()- furniture.getPublishedYear();        
//                    buyer.setWallet(wallet);
                //-----------------
                request.getRequestDispatcher("/WEB-INF/takeOnFurnitureForm.jsp").forward(request, response);
                break;
            case "/takeOnFurniture":
                String furnitureId = request.getParameter("furnitureId");
                furniture = furnitureFacade.find(Long.parseLong(furnitureId));
                String buyerId = request.getParameter("buyerId");
                buyer = buyerFacade.find(Long.parseLong(buyerId));
                History history = new History(furniture, buyer, new GregorianCalendar().getTime(), null);
                historyFacade.create(history);
                request.setAttribute("info", "the furniture \""+furniture.getName()+"\"was gave out");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/returnFurnitureForm":
                List<History> listReadFurnitures = historyFacade.findReadFurniture();
                request.setAttribute("listReadFurnitures", listReadFurnitures);
                request.getRequestDispatcher("/WEB-INF/returnFurnitureForm.jsp").forward(request, response);
                break;    
            case "/returnFurniture":
                String historyId = request.getParameter("historyId");
                history = historyFacade.find(Long.parseLong(historyId));
                history.setReturnDate(new GregorianCalendar().getTime());
                historyFacade.edit(history);
                request.setAttribute("info", "Furniture \""+history.getFurniture().getName()+"\" return to shop");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
        }               
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
// <!--
//int wallet =buyer.getWallet()- furniture.getPrice();        
//        buyer.setWallet(wallet)
//-->          
//<!------------emptying the buyers wallet---->