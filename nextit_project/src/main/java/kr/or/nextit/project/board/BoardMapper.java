package kr.or.nextit.project.board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper{
	List<BoardDTO> selectBoards();
	BoardDTO selectBoard(int id);
	void updateHits(int id);
	int registerBoard(BoardDTO board);
	int modifyBoard(BoardDTO board);
	int removeBoard(int id);
}
