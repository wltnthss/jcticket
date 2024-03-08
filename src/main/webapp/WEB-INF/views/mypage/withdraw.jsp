<%--
  Created by IntelliJ IDEA.
  User: wjswo
  Date: 2024-02-22
  Time: PM 7:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        #wrap {
            height: 100%;
            padding: 0px 0px 500px 0px;
        }

        #container {
            width: 960px;
            height: 921px;
            margin: auto;
        }

        #con {
            width: 100%;
        }

        #withdraw_header {
            text-align: center;
            width: 100%;
            height: 100px;
            background-color: #6699cc;
        }

        #withdraw_header > h1 {
            padding: 34px;
        }

        #withdraw-mid {
            width: 100%;
            height: 500px;
        }

        #withdraw-mid > h2 {
            margin: 10px 0px;
        }

        #grp_cell {
            margin: 20px 0px;
        }
        #grp_cell > h3{
            margin: 10px 0px;
        }

        #grp_cell > p{
            color:  red;
        }

        #grp_cell > ul {
            margin: 5px 0px;
            list-style: none;
            font-size: 13px;
        }

        #grp_cell > ul > li {
            margin: 10px 0px;
        }

    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>


<hr>
<br>
<br>

<div id="wrap">
    <div id="container">
        <article id="con">
            <div id="withdraw_header">
                <h1>회원탈퇴</h1>
            </div>

            <div id="withdraw-mid">
                <h2>아래 내용을 꼭 확인해 주세요.</h2>

                <div class="yesContGrp">
                    <div id="grp_cell">
                            <h3>회원정보 및 계좌내역 삭제</h3>

                                <p>회원탈퇴 즉시 회원정보는 모두 삭제되며, 재가입시에도 복원되지 않습니다.</p>
                                <ul>
                                    <li><em class="bl_dot bgYUI">&nbsp;</em>삭제되는 정보 : 구매하신 eBook, 개인정보, 계좌내역(YES포인트, YES머니,
                                        예치금 등), YES블로그 계정, 예스24 중고샵 판매관리 계정
                                    </li>
                                    <li><em class="bl_dot bgYUI">&nbsp;</em>회원탈퇴 시 중고샵 판매계정 및 판매자회원 자격이 자동으로 상실됩니다.(주문/정산
                                        중에는 탈퇴불가)
                                    </li>
                                    <li><em class="bl_dot bgYUI">&nbsp;</em>회원탈퇴 시 중고매장에서 회원으로 서비스 이용이 불가합니다.</li>
                                    <li><em class="bl_dot bgYUI">&nbsp;</em>회원탈퇴 시 구매하신 eBook도 모두 삭제됩니다. 회원탈퇴 후 타 ID로 사용 권한을
                                        양도하실 수 없습니다.
                                    </li>
                                    <li><em class="bl_dot bgYUI">&nbsp;</em>탈퇴 후 블로그 및 블로그와 연결된 이용기록(ex.상품리뷰)은 모두 삭제되며, 삭제된
                                        데이터는 복구되지 않습니다.
                                    </li>
                                    <li><em class="bl_dot bgYUI">&nbsp;</em>게시판형 서비스에 등록한 게시물은 삭제되지 않고 유지됩니다.</li>
                                </ul>
                    </div>
                </div>
                <br>
                <hr>

                <div class="grp_cell">
                    <dl class="yesAlertDl b_size">
                        <dt>1개월간 회원 재가입 제한</dt>
                        <dd>
                            <p class="yesAlertP">회원탈퇴 후, 1개월간은 회원 재가입이 불가능합니다.</p>
                        </dd>
                    </dl>
                </div>

                <div class="grp_cell">
                    <dl class="yesAlertDl b_size">
                        <dt>탈퇴 후 정보보관</dt>
                        <dd>
                            <p class="yesAlertP">
                                전자상거래 등에서의 소비자보호에 관한 법률 제6조에 의거 성명, 주소 등 거래의 주체를 식별할 수 있는 정보에 한하여 서비스<br>
                                이용에 관한 동의를 철회한 경우에도 이를 보존할 수 있으며, 동법 시행령 제6조에 의거 다음과 같이 거래 기록을 보관합니다.
                            </p>
                            <ul class="yesAlertLi mgt5">
                                <li><em class="bl_dot bgYUI">&nbsp;</em>표시, 광고에 관한 기록 : 6개월               </li>
                                <li><em class="bl_dot bgYUI">&nbsp;</em>계약 또는 청약철회 등에 관한 기록 : 5년      </li>
                                <li><em class="bl_dot bgYUI">&nbsp;</em>대금결제 및 재화등의 공급에 관한 기록 : 5년  </li>
                                <li><em class="bl_dot bgYUI">&nbsp;</em>소비자의 불만 또는 분쟁처리에 관한 기록 : 3년</li>
                            </ul>
                        </dd>
                    </dl>
                </div>

            </div>

            <div id="chkPw" class="yesFormGrayBox chkPwBox">
                <div class="yesFormGrayBox_cont">
                    <div class="yesIptRow">
								<span class="yesIpt m_size ipt_wSizeF">
									<label for="CLabMemId"></label>
                                    <input name="CLabMemId" type="text" id="CLabMemId" readonly="readonly">
								</span>
                    </div>
                    <div class="yesIptRow mgt10">
								<span class="yesIpt m_size ipt_wSizeF focus_blue  labelHide">
									<label for="password">비밀번호</label>
									<input name="password" type="password" id="password" maxlength="20" data-gtm-form-interact-field-id="0">
								</span>
                    </div>
                </div>
            </div>


        </article>
    </div>
</div>

<br>
<br>
<hr>


<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>
