package kr.or.nextit.project.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @GetMapping("/boards")
    public String boards(Model model) {
        List<BoardDTO> boards = service.selectBoards();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/boards/detail")
    public String selectBoard(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
        BoardDTO board = service.selectBoard(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/boards/register")
    public String registerBoard() {
        return "board/register";
    }

    @PostMapping("/boards/register")
    public String registerBoard(@ModelAttribute BoardDTO board, MultipartFile files) throws IOException {
        service.registerBoard(board);
        return "redirect:/boards";
    }

    @GetMapping("/boards/modify")
    public String modifyBoard(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
        BoardDTO board = service.selectBoard(id);
        model.addAttribute("board", board);
        return "board/modify";
    }

    @PostMapping("/boards/modify")
    public String modifyBoard(@ModelAttribute BoardDTO board) {
        service.modifyBoard(board);
        return "redirect:/boards/detail?id=" + board.getId();
    }

    @GetMapping("/boards/remove")
    public String removeBoard(int id) {
        service.removeBoard(id);
        return "redirect:/boards";
    }

}