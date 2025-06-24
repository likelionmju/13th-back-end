package com.example.ll_week10;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "ProfileAPI", description = "학생 성적 관리 API")
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/register")
    @Operation(summary = "학생 추가", description = "name, number, score로 추가")
    public void register(@RequestBody Profile profile) {
        profileService.save(profile);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Id로 찾기", description = "Id로 학생 찾기")
    public Profile findById(@PathVariable Long id) {
        return profileService.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Name으로 찾기", description = "name으로 학생 찾기")
    public Profile findByName(@PathVariable String name) {
        return profileService.findByName(name);
    }

    @GetMapping("/all")
    @Operation(summary = "모든 학생정보 찾기", description = "모든 학생정보 출력")
    public List<Profile> findAll() {
        return profileService.findAll();
    }

    @GetMapping("/Top3")
    @Operation(summary = "상위 3명 학생 찾기", description = "성적 상위 3명 찾기")
    public List<Profile> findTop3() {
        return profileService.findTop3ByOrderByScoreDesc();
    }

    @PutMapping("/update")
    @Operation(summary = "성적 수정", description = "ID로 탐색 후 성적 수정")
    public Profile update(@RequestBody Profile profile) {
        return profileService.update(profile);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Id로 탐색 후 삭제", description = "Id로 학생 정보 삭제")
    public void delete(@PathVariable Long id) {
        profileService.delete(id);
    }
}
