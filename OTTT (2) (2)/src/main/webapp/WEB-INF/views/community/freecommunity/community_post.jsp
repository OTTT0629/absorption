<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>community_post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script type="text/javascript" src="js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${path}/resources/css/community/freecommunity/community_post.css" >
  </head>

<!--  body  --------------------->
  <body style="background-color: #202020;">
    <div class="wrap">
      <header >
        <div class="logo">
          <a href="<c:url value="/" />">
            <img src="${path}/resources/images/logo/OTTT.png" alt="로고">
          </a>
        </div>
        <nav class="gnb">
          <ul>
            <li>
              <a href="<c:url value="/genre/movie" />">영화</a>
            </li>
            <li>
              <a href="<c:url value="/genre/drama" />">드라마</a>
            </li>
            <li>
              <a href="<c:url value="/genre/interest" />">예능</a>
            </li>
            <li>
              <a href="<c:url value="/genre/animation" />">애니</a>
            </li>
            <li>
              <a href="<c:url value="/community" />" style="color: #33ff33;">게시판</a>
            </li>
          </ul>
        </nav>
        <div class="h-icon">
          <ul>
            <li>
              <a href="<c:url value='/search' />">
                <!-- <img src="./images/icon/search02.png" alt="검색"> -->
              </a>
            </li>
            <li>
              <a href="<c:url value='/mypage' />">
                <!-- <img src="./images/icon/user01.png" alt="내 정보"> -->
              </a>
            </li>
          </ul>
        </div>
      </header>
      <main>
        <div id="line-1" >
          <nav class="nav">
          <a class="nav-link1" href="<c:url value='/community' />" style="color: #33ff33;">자유게시판</a>
          <a class="nav-link1" href="<c:url value='/community/endmovie/tving' />">종료예정작</a>
          <a class="nav-link1" href="<c:url value='/community/priceInfoTving' />">가격정보</a>
          <a class="nav-link1" href="<c:url value='/community/QnA' />">Q&A</a>
          <a class="nav-link1" href="<c:url value='/community/notice' />">공지사항</a>
        </nav>
        </div>
        <div id="line-2">
          <div class="Lcontent">
            <form name="post_search" action="" method="get">
              <input class="search" type="search" placeholder=" &nbsp;Search">
              <input class="searchicon" type="image" src="${path}/resources/images/icon/search.png" alt="돋보기">
            </form>
            <ul class="movepage">
              <li style="display: flex;">
                <div class="list-group">
                    <a href="<c:url value='/mycommynity/postcommu' />" class="list-group-item list-group-item-action">
                      <img class="side_img" src="${path}/resources/images/img/KakaoTalk_20230411_161709664.png" alt="post">내가 쓴 게시글
                    </a>
                </div>
              </li>
              <li style="display: flex;">
                  <div class="list-group">
                      <a href="<c:url value='/mycommynity/likecommunity' />" class="list-group-item list-group-item-action">
                        <img class="side_img" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">좋아요 누른 게시글
                      </a>
                  </div>
              </li>
              <li style="display: flex;">
                  <div class="list-group">
                      <a href="<c:url value='/mycommynity/comment' />" class="list-group-item list-group-item-action">
                        <img class="side_img" src="${path}/resources/images/img/comment.png" >댓글 작성 게시물
                      </a>
                  </div>
              </li>
              <li style="display: flex;">
                  <div class="list-group">
                      <a href="#" class="list-group-item list-group-item-action" style="margin-top: 2vw; height: 35vh;">광고</a>
                    </div>
              </li>
          </div>

<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
          <div class="Rcontent" >
            <div class="maintext">
              <div class="post_info" >
                <ul style="display: flex;">
                  <li>
                    <a href="#"><img class="profile" src="${path}/resources/images/icon/user01.png" alt="profile"></a>
                  </li>
                  <li>
                    <a class="nickname_main" href="#">뚜벅초</a>
                  </li>
                  <li>
                      <button type="button" class="btn_warning" data-bs-toggle="dropdown" aria-expanded="false">
                        신고
                      </button>
                      <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">욕설/비방</a></li>
                        <li><a class="dropdown-item" href="#">광고/도배</a></li>
                        <li><a class="dropdown-item" href="#">악의적인 스포</a></li>
                        <li><a class="dropdown-item" href="#">선정성</a></li>
                      </ul>
                  </li>
                </ul>
              </div> 
            <div class="wirted">
                스즈메는 영화에서 나오는 마지막 문을 열고 들어가 쓰나미로 인해 자신이 가장 사랑하는 사람을 잃은 자신의 어린 시절을 마주한다. 
                자신의 세계에서 가장 큰 부분을 차지하고 있던 사람이 한순간에 없어진다는 것은 그 슬픔의 깊이를 감히 상상할 수 없을 만큼 고통스럽다. 
                그것을 마주한 사람이 어린아이일 경우 느끼게 되는 고통, 공포감은 죽음이라는 개념을 아는 이들보다 더할 것이다.
                예상치 못한 우리 곁의 모든 재난, 재해는 집 문을 열고 ‘다녀오겠습니다’라고 말하고 돌아와 문을 닫으며 ‘다녀왔습니다’라고 말하는 일상을 보지 못하게 한다. 
                재해 후 남은 이들은 이런 사소한 일상조차 그들에게 너무나 소중한 기억이 된다. 굳게 닫힌 문은 이들의 평범한 일상을 단절시키는 것과 같다.
                고등학생의 스즈메는 어린 시절 자기 모습을 마주한 다음, 어린 시절의 그녀에게 “너의 미래를 두려워하지 마. 너는 잘 해낼 수 있어”라고 말한다. 
                이는 어린 시절의 그녀에게만 하는 말이 아니라 현재의 스즈메에게도 하는 말로 들린다. 이 문장은 아픔을 지닌 사람들이 마음속에 떠올리는 의문 중 하나인 
                ‘내가 그 사람 없이, 앞으로도 계속해서 살아갈 수 있을까?’에 대한 답이 된다. 따라서 이 문장은 재해의 고통을 입은 세상의 많은 스즈메에게 전하는 메시지이기도 하다.
                <img class="poster" src="${path}/resources/images/poster/스즈메포스터.png" alt="poster">
                <p id="current_date" >작성한 날짜</p>
            </div>
            <div class="pro-total">
                <div class="pro-info">
                  <input class="heart" type="image" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">
                  <span>5</span> 
                  <span><img class="re_comment_img" src="${path}/resources/images/img/comment.png"></span>
                  <span>10</span> 
                  </div>
                    <div class="modi-del">
                      <!-- Button trigger modal -->
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                      수정
                    </button>
                      <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                      <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">알림</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                            수정하시겠습니까?
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-primary">Yes</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModa2">
                      삭제
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModa2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                      <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabe2">알림</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                            삭제하시겠습니까?
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-primary">Yes</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                          </div>
                        </div>
                      </div>
                    </div>                    
                  </div> 
              </div>
            </div>

        <!--댓글-->
            <ul class="Comment">
              <li class="comment_write">
                <a href="#"><img class="profile" src="${path}/resources/images/icon/user01.png" alt="profile" ></a>
                <a class="nickname" href="#">피카츄</a>
                <div>
                <textarea class="writeHere" placeholder="Write Here" onkeydown="resize(this)" onkeyup="resize(this)" ></textarea>
                <input class="btn_commit" type="image" src="${path}/resources/images/img/commit.png" alt="commit">
                </div>
              </li>
              <li class="comment_show">
               <div class="pro-dan">
                <div>
                  <a href="#"><img class="profile" src="${path}/resources/images/icon/user01.png" alt="profile" ></a>
                  <a class="nickname" href="../ottt박소율/mypageshow.html">user</a>
                </div>
                  <div class="btn_warning_div">
                    <button type="button" class="btn_warning2" data-bs-toggle="dropdown" aria-expanded="false">
                     신고
                    </button>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">비방/욕설</a></li>
                      <li><a class="dropdown-item" href="#">광고/도배</a></li>
                      <li><a class="dropdown-item" href="#">악의적인 스포</a></li>
                      <li><a class="dropdown-item" href="#">선정성</a></li>
                    </ul>
                  </div>
                </div>
                <div class="comment_write_box">
                <p>
                  나는 스즈메의 내일이란다<br>
                  스즈메 좋아! 너는 방해돼<br>
                  있자나 너 , 이 근처에 폐허 없니<br>
                  스즈메, 대단해<br>
                  돌려 드리겠습니다<br>
                  죽는게 두려워!!!! ..살고싶어...살고싶어...!<br>
                  좋아하는 사람이 있는 곳에<br>
                  소타씨가 없는 세상이 저는 두려워요!<br>
                  구해줘서 고마워, 만나러 갈게 꼭<br>
                  스즈메, 나를 구해줘서 고마워<br>
                  사라지고 싶지않아 ..더 살고 싶어<br>
                  죽는게 무서워 살고 싶어.. 살고... 싶어<br>
                  두렵지 않아요
                </p>
                 <span class="select_box">
                   <input class="heart" type="image" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">
                   <span>4</span> 
                 </span>
                </div>
              </li>
              <li class="comment_show">
               <div class="pro-dan">
                <div>
                  <a href="#"><img class="profile" src="${path}/resources/images/icon/user01.png" alt="profile" ></a>
                  <a class="nickname" href="../ottt박소율/mypageshow.html">user</a>
                </div>
                  <div class="btn_warning_div">
                    <button type="button" class="btn_warning2" data-bs-toggle="dropdown" aria-expanded="false">
                     신고
                    </button>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">비방/욕설</a></li>
                      <li><a class="dropdown-item" href="#">광고/도배</a></li>
                      <li><a class="dropdown-item" href="#">악의적인 스포</a></li>
                      <li><a class="dropdown-item" href="#">선정성</a></li>
                    </ul>
                  </div>
                </div>
                <div class="comment_write_box">
                <p>
                  나는 스즈메의 내일이란다<br>
                  스즈메 좋아! 너는 방해돼<br>
                  있자나 너 , 이 근처에 폐허 없니<br>
                  스즈메, 대단해<br>
                  돌려 드리겠습니다<br>
                  죽는게 두려워!!!! ..살고싶어...살고싶어...!<br>
                  좋아하는 사람이 있는 곳에<br>
                  소타씨가 없는 세상이 저는 두려워요!<br>
                  구해줘서 고마워, 만나러 갈게 꼭<br>
                  스즈메, 나를 구해줘서 고마워<br>
                  사라지고 싶지않아 ..더 살고 싶어<br>
                  죽는게 무서워 살고 싶어.. 살고... 싶어<br>
                  두렵지 않아요
                </p>
                 <span class="select_box">
                   <input class="heart" type="image" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">
                   <span>4</span> 
                 </span>
                </div>
              </li>
            </ul>
          </div>
        </div>
        </div>
      </main>
    </div>
  </body>
</html>