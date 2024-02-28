
$(document).ready(function() {
    $('.btn_large').click(function(event) {
        // 기본 동작 막기
        event.preventDefault();

        // 파일을 선택한 input 요소
        var fileInput = $('#play_poster')[0];

        // 파일이 첨부되었는지 확인
        if (fileInput.files.length > 0) {
            // FormData 객체 생성
            var formData = new FormData();
            // 파일 추가
            formData.append('play_poster', fileInput.files[0]);

            // AJAX를 사용하여 서버로 데이터 전송
            $.ajax({
                url: 'your_controller_url',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function(response) {
                    // 성공적으로 전송된 경우
                    alert('신청이 완료되었습니다.');
                    // 페이지 리다이렉트 등 필요한 작업 수행
                },
                error: function(xhr, status, error) {
                    // 전송 실패 시 처리
                    alert('전송에 실패했습니다.');
                }
            });
        } else {
            // 파일이 첨부되지 않은 경우
            alert('파일을 첨부해주세요.');
        }
    });
});