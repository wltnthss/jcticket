<%--
  Created by IntelliJ IDEA.
  User: 82109
  Date: 2024-02-13
  Time: 오전 6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jcticket.agency.dto.AgencyDto" %>
<%@ page import="com.jcticket.agency.dao.AgencyDao" %>
<%@ page import="com.jcticket.agency.dao.AgencyDaoImpl" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 파라미터로부터 사용자 입력 값을 추출
    String playName = request.getParameter("play_name");
    String playSubName = request.getParameter("play_sub_name");
    String playMajorCategory = request.getParameter("play_major_cat");
    String stageName = request.getParameter("stage_name");
    String stageAddress = request.getParameter("stage_address");
    String showingStartAt = request.getParameter("showing_start_at");
    String showingEndAt = request.getParameter("showing_end_at");
    String playRunTime = request.getParameter("play_run_time");
    String showingInfo = request.getParameter("showing_info");
    String playPoster = request.getParameter("play_poster");
    // AgencyDto 객체 생성 및 값 설정
    AgencyDto agencyDto = new AgencyDto();
    agencyDto.setPlayName(playName);
    agencyDto.setPlaySubTitle(playSubName);
    agencyDto.setPlayMajorCategory(playMajorCategory);
    agencyDto.setStageName(stageName);
    agencyDto.setStageAddress(stageAddress);
    agencyDto.setShowingStartAt(showingStartAt);
    agencyDto.setShowingEndtAt(showingEndAt);
    agencyDto.setPlayRunTime(playRunTime);
    agencyDto.setShowingInfo(showingInfo);
    agencyDto.setPlayPoster(playPoster);


    // AgencyDao 객체생성
    AgencyDao agencyDao = new AgencyDaoImpl();

    // AgencyDao를 사용하여 DB에 데이터 저장
    try {
        agencyDao.save(agencyDto);
        // DB 저장이 성공한 경우, 성공 페이지로 리다이렉트
        response.sendRedirect("success.jsp");
    } catch (Exception e) {
        // DB 저장 중 오류 발생 시, 오류 메시지 출력
        out.println("DB 저장 중 오류가 발생했습니다: " + e.getMessage());
        //  오류 처리 페이지로 이동시키는 방법도 존재
        // response.sendRedirect("error.jsp");
    }
%>
</body>
</html>
