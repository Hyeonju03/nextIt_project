package kr.or.nextit.project.board;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper mapper;

	List<BoardDTO> selectBoards() {
		return mapper.selectBoards();
	}

	@Transactional
	public BoardDTO selectBoard(int id) {
		mapper.updateHits(id);
		return mapper.selectBoard(id);
	}

	@Transactional
	public int registerBoard(BoardDTO board) {
		return mapper.registerBoard(board);
	}

	int modifyBoard(BoardDTO board) {
		return mapper.modifyBoard(board);
	}

	int removeBoard(int id) {
		return mapper.removeBoard(id);
	}

}
