import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet(name = "gameServlet", urlPatterns = {"/index"})
public class GameServlet extends HttpServlet {
    List<Player> players = new ArrayList<>();
    Random random = new Random();
    int numberRandom = random.nextInt(1001);
    int clickCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime myObj = LocalDateTime.now();
        int number = 0;
        String message = "";
        if (!req.getParameter("number").isEmpty())
            number = Integer.parseInt(req.getParameter("number"));
        else{
            message="Bạn chưa nhập gì hết. Vui lòng nhập lại !";
            req.setAttribute("players", players);
            req.setAttribute("msg", message);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        if (number>1000 || number<0){
            message="Bạn đã nhập ngoài khoảng cho phép [1,1000] vui lòng nhập lại trong khoảng !";
            req.setAttribute("players", players);
            req.setAttribute("msg", message);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        clickCount++;
        if (number < numberRandom) {
            message = "Số của bạn vừa nhập nhỏ hơn kết quả. Mời bạn nhập lại";
        } else if (number > numberRandom) {
            message = "Số của bạn vừa nhập lớn hơn kết quả. Mời bạn nhập lại";
        }
        if (number == numberRandom) {
            message = "CHÚC MỪNG BẠN ĐÃ ĐOÁN ĐÚNG!!" +
                    "Nếu muốn chơi tiếp mời bạn đoán số mới.";
            Player player = new Player();
            player.setClickCount(clickCount);
            player.setTimeDone(myObj);
            players.add(player);
            Collections.sort(players);
            numberRandom = random.nextInt(1001);
            clickCount=0;
        }
        req.setAttribute("players", players);
        req.setAttribute("msg", message);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
