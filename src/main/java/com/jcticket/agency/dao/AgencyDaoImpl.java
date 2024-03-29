package com.jcticket.agency.dao;

import com.jcticket.agency.dto.*;
import com.jcticket.notice.dto.NoticeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jcticket.viewdetail.dto.ShowingDto;
//import com.jcticket.viewdetail.dto.PlayDto;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.Collections;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


/**
 * packageName    : com.jcticket.agency.dao
 * fileName       : AgencyDaoImpl
 * author         : {sana}
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        {sana}       최초 생성
 */


//4.DaoImpl : AgencyDao의 interface를  implements한 AgencyDaoImpl class 라는 말 같음.
//그러니까 AgencyDao의 interface를 구현해서 db와 상호작용하며, SqlSession 객체를 주입받고
//그를 사용하여 매퍼에서 정의된 SQL 쿼리를 실행

    @Repository
    public class AgencyDaoImpl implements AgencyDao {

        private static final String namespace = "AgencyMapper.";
        //AgencyMapper.xml랑 연결?

        private static final String INSERT_IMAGE_SQL = "UPDATE play SET play_poster = ? WHERE play_id = ?";

        private DataSource dataSource; // 데이터베이스 연결용 DataSource

        @Autowired
        public AgencyDaoImpl(DataSource dataSource) {// 생성자를 통해서 의존성 주입
            this.dataSource = dataSource;
        }



    @Autowired//SqlSession객체를  자동 연결해서 주입받음 (의존성 주입)
    private SqlSession sqlSession;



    @Override
    public AgencyDto selectAgency(String agency_id) throws Exception {
        return sqlSession.selectOne(namespace + "AgencyLogin", agency_id);
    }//selectAgency 메서드는 SqlSession 객체를 사용해 db에서 쿼리를 실행?

    @Override
    public int insertAgency(AgencyDto agencyDto) throws Exception {
        return sqlSession.insert(namespace+"AgencyInsert", agencyDto);
    }

    @Override
    public int deleteAgency() throws Exception {
        return sqlSession.delete(namespace + "AgencyDelete");
    }

    @Override
    public int agencyCount() throws Exception {
        return sqlSession.selectOne(namespace + "AgencyCount");
    }



    @Override
    public List<EnrollDto> selectAll(int offset, int limit) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("limit", limit);

        return sqlSession.selectList(namespace + ".selectAll", params);
    }



//    @Override
//    public List<EnrollDto> selectAll() throws Exception {
//        return sqlSession.selectList(namespace+"selectAll");
//    }


//    @Override
//    public void insertImage(String playId, String imagePath) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IMAGE_SQL)) {
//            preparedStatement.setString(1, imagePath);
//            preparedStatement.setString(2, playId);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            //나중에 예외처리 변경 하기
//        }
//    }


//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void insertPlay(PlayDto playDto) {
//        try (Connection connection = sqlSession.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO play (play_id, play_name, play_poster, play_info, play_major_cat, play_middle_cat, play_small_cat, play_run_time, agency_id, created_at, created_id, updated_at, updated_id) " +
//                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
//            preparedStatement.setString(1, playDto.getPlay_id());
//            preparedStatement.setString(2, playDto.getPlay_name());
//            preparedStatement.setString(3, playDto.getPlay_poster());
//            preparedStatement.setString(4, playDto.getPlay_info());
//            preparedStatement.setString(5, playDto.getPlay_major_cat());
//            preparedStatement.setString(6, playDto.getPlay_middle_cat());
//            preparedStatement.setString(7, playDto.getPlay_small_cat());
//            preparedStatement.setInt(8, playDto.getPlay_run_time());
//            preparedStatement.setString(9, playDto.getAgency_id());
//            preparedStatement.setTimestamp(10, playDto.getCreated_at());
//            preparedStatement.setString(11, playDto.getCreated_id());
//            preparedStatement.setTimestamp(12, playDto.getUpdated_at());
//            preparedStatement.setString(13, playDto.getUpdated_id());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // 예외 처리
//        }
//    }
//
//    @Override
//    @Transactional
//    public void insertShowing(ShowingDto showingDto) {
//        try (Connection connection = sqlSession.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO showing (showing_seq, showing_start_at, showing_end_at, showing_info, showing_date, showing_day, showing_status, showing_seat_cnt, showing_seat_price, play_id, stage_id, created_at, created_id, updated_at, updated_id) " +
//                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
//            preparedStatement.setInt(1, showingDto.getShowing_seq());
//            preparedStatement.setTimestamp(2, showingDto.getShowing_start_at());
//            preparedStatement.setTimestamp(3, showingDto.getShowing_end_at());
//            preparedStatement.setString(4, showingDto.getShowing_info());
//            preparedStatement.setString(5, showingDto.getShowing_date());
//            preparedStatement.setString(6, showingDto.getShowing_day());
//            preparedStatement.setString(7, showingDto.getShowing_status());
//            preparedStatement.setInt(8, showingDto.getShowing_seat_cnt());
//            preparedStatement.setInt(9, showingDto.getShowing_seat_price());
//            preparedStatement.setString(10, showingDto.getPlay_id());
//            preparedStatement.setString(11, showingDto.getStage_id());
//            preparedStatement.setTimestamp(12, showingDto.getCreated_at());
//            preparedStatement.setString(13, showingDto.getCreated_id());
//            preparedStatement.setTimestamp(14, showingDto.getUpdated_at());
//            preparedStatement.setString(15, showingDto.getUpdated_id());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // 예외 처리
//        }
//    }
//
//    @Override
//    public void insertStage(StageDto stageDto) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO stage (stage_id, stage_name, stage_address, stage_seat_cnt, stage_manager, stage_type, stage_tel, created_at, created_id, updated_at, updated_id) " +
//                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
//            preparedStatement.setString(1, stageDto.getStage_id());
//            preparedStatement.setString(2, stageDto.getStage_name());
//            preparedStatement.setString(3, stageDto.getStage_address());
//            preparedStatement.setInt(4, stageDto.getStage_seat_cnt());
//            preparedStatement.setString(5, stageDto.getStage_manager());
////            preparedStatement.setString(6, stageDto.getStage_type());
//            preparedStatement.setString(7, stageDto.getStage_tel());
//            preparedStatement.setTimestamp(8, stageDto.getCreated_at());
//            preparedStatement.setString(9, stageDto.getCreated_id());
//            preparedStatement.setTimestamp(10, stageDto.getUpdated_at());
//            preparedStatement.setString(11, stageDto.getUpdated_id());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // 예외 처리
//        }
//    }
//-----
//@Override
//public List<StageDto> getAllStages() {
//    return sqlSession.selectList(namespace + "getAllStages");
//}

//    @Override
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    @Override
//    public List<StageDto> getAllStages() {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stage");
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//            List<StageDto> stages = new ArrayList<>();
//            while (resultSet.next()) {
//                StageDto stageDto = new StageDto();
//                stageDto.setStage_id(resultSet.getString("stage_id"));
//                stageDto.setStage_name(resultSet.getString("stage_name"));
//                stageDto.setStage_address(resultSet.getString("stage_address"));
//                stageDto.setStage_seat_cnt(resultSet.getInt("stage_seat_cnt"));
//                stageDto.setStage_manager(resultSet.getString("stage_manager"));
////                stageDto.setStage_type(resultSet.getString("stage_type"));
//                stageDto.setStage_tel(resultSet.getString("stage_tel"));
//                stageDto.setCreated_at(resultSet.getTimestamp("created_at"));
//                stageDto.setCreated_id(resultSet.getString("created_id"));
//                stageDto.setUpdated_at(resultSet.getTimestamp("updated_at"));
//                stageDto.setUpdated_id(resultSet.getString("updated_id"));
//
//                stages.add(stageDto);
//            }
//            return stages;
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            return Collections.emptyList(); // 예외 발생 시 빈 리스트 반환인데 , 예외 발생 시 에러페이지? 이동이나 전체 저장 안되도록
//        }
//    }
//
//
//    @Override
//    public List<PlayDto> getAllPlays() {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM play");
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//            List<PlayDto> plays = new ArrayList<>();
//            while (resultSet.next()) {
//                PlayDto playDto = new PlayDto();
//                playDto.setPlay_id(resultSet.getString("play_id"));
//                playDto.setPlay_name(resultSet.getString("play_name"));
//                playDto.setPlay_poster(resultSet.getString("play_poster"));
//                playDto.setPlay_info(resultSet.getString("play_info"));
//                playDto.setPlay_major_cat(resultSet.getString("play_major_cat"));
//                playDto.setPlay_middle_cat(resultSet.getString("play_middle_cat"));
//                playDto.setPlay_small_cat(resultSet.getString("play_small_cat"));
//                playDto.setPlay_run_time(resultSet.getInt("play_run_time"));
//                playDto.setAgency_id(resultSet.getString("agency_id"));
//                playDto.setCreated_at(resultSet.getTimestamp("created_at"));
//                playDto.setCreated_id(resultSet.getString("created_id"));
//                playDto.setUpdated_at(resultSet.getTimestamp("updated_at"));
//                playDto.setUpdated_id(resultSet.getString("updated_id"));
//
//                plays.add(playDto);
//            }
//            return plays;
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            return Collections.emptyList();
//        }
//    }
//
//    @Override
//    public List<ShowingDto> getAllShowings() {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM showing");
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//            List<ShowingDto> showings = new ArrayList<>();
//            while (resultSet.next()) {
//                ShowingDto showingDto = new ShowingDto();
//                showingDto.setShowing_seq(resultSet.getInt("showing_seq"));
//                showingDto.setShowing_start_at(resultSet.getTimestamp("showing_start_at"));
//                showingDto.setShowing_end_at(resultSet.getTimestamp("showing_end_at"));
//                showingDto.setShowing_info(resultSet.getString("showing_info"));
//                showingDto.setShowing_date(resultSet.getString("showing_date"));
//                showingDto.setShowing_day(resultSet.getString("showing_day"));
//                showingDto.setShowing_status(resultSet.getString("showing_status"));
//                showingDto.setShowing_seat_cnt(resultSet.getInt("showing_seat_cnt"));
//                showingDto.setPlay_id(resultSet.getString("play_id"));
//                showingDto.setStage_id(resultSet.getString("stage_id"));
//                showingDto.setCreated_at(resultSet.getTimestamp("created_at"));
//                showingDto.setCreated_id(resultSet.getString("created_id"));
//                showingDto.setUpdated_at(resultSet.getTimestamp("updated_at"));
//                showingDto.setUpdated_id(resultSet.getString("updated_id"));
//
//                showings.add(showingDto);
//            }
//            return showings;
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            return Collections.emptyList();
//        }
//    }




    //로그인에 왜 CRUD를 전부 적어둬야 하는지 모르겠으나.. 시켜서 적는..

//    @Override
//    public void insertAgency(AgencyDto agencyDto) throws Exception {
//        sqlSession.insert(namespace + "insertAgency", agencyDto);
//    }
//
//    @Override
//    public void updateAgency(AgencyDto agencyDto) throws Exception {
//        sqlSession.update(namespace + "updateAgency", agencyDto);
//    }
//
//    @Override
//    public void deleteAgency(String agency_id) throws Exception {
//        sqlSession.delete(namespace + "deleteAgency", agency_id);
//    }



    @Override
    public int insertEnroll(EnrollDto enrollDto) throws Exception {
        return sqlSession.insert(namespace+"insertenroll", enrollDto);
    }



}//selectOne 메서드를 사용해 db에서 한 개의 결과를 가져오는 쿼리를 실행하고, 결과를 AgencyDto 객체로 매핑해서 return