package hello.grademanager;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "StudentApi", description = "학생 성적 관리 API")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    @Operation(summary = "학생 등록", description = "이름, 학번, 점수를 받는다.")
    public Student save(@RequestBody Student student){
        return studentService.register(student);
    }

    @GetMapping("/student/id")
    @Operation(summary = "ID로 조회")
    public Student findById(@RequestParam Long id){
        return studentService.findById(id);
    }

    @GetMapping("/student/name")
    @Operation(summary = "이름으로 조회")
    public List<Student> findByName(@RequestParam String name){
        return studentService.findByName(name);
    }

    @GetMapping("/student/all")
    @Operation(summary = "전체 조회")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/student/top3Score")
    @Operation(summary = "성적 1~3등 조회", description = "1등부터 내림차순으로 조회")
    public List<Student> findTop3Score(){
        return studentService.findTop3ByOrderByScoreDesc();
    }

    @PutMapping("/update")
    @Operation(summary = "학생 정보 수정", description = "해당 id 없을 시 -> 런타임에러")
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "학생 삭제", description = "해당 id 없을 시 -> 런타임에러")
    public void deleteById(@RequestParam Long id) {
        studentService.deleteById(id);
    }
}