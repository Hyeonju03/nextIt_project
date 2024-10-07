package kr.or.nextit.project.board;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardDTO {
	private int id;
	private String title;
	private String content;
	private String writer;
	private int hits;
	private LocalDateTime registerDate;
	private LocalDateTime modifiedDate;
}
