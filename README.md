# 42MARU X KUSITHMS
> 한국어 뉴스 요약 모델을 활용한 개인화된 뉴스추천 서비스

### Login
- Check
  - 필수사항 입력

``` Kotlin
if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
Toast.makeText(this, "아이디와 비밀번호는 필수 입력 사항입니다.”,Toast.LENGTH_SHORT).show()
```
  - 처음 입력한 아이디와 비밀번호 확인
``` Kotlin
Toast.makeText(this, "아이디와 비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show()
```
> Room Library를 사용하여 사용자 데이터 저장

<img src="https://user-images.githubusercontent.com/77282190/158851366-644659bc-2b38-4d4d-930e-44823c1f0beb.gif" width="230" height="480"/>
                                                                                                                                          
-----------

## HashTag
- 개개인의 관심키워드 설정
  - TagList를 통해 사용자가 사용자 데이터를 tagData에 저장
  - 리사이클러뷰를 사용하여 데이터를 뷰에 보여줌
> 설정한 태그마다 Fragment로 설정
<img src="https://user-images.githubusercontent.com/77282190/158851595-41dcf0c8-21b9-4703-b3d7-9a9f281ee100.gif" />

---------

## News
- 즐겨보는 뉴스 트렌드 목록 
  - 데이터 수집(뉴스 imgUrl, text, title, url DB화)
  - 목록을 클릭했을 때 뉴스 보기 화면으로 전환
```Kotlin
//리스트를 클릭했을 때 뉴스 보기 화면으로 전환
holder.nbinding.newsTitle.setOnClickListener(View.OnClickListener { v ->
    var intent = Intent(v.context, DetailActivity::class.java)
    intent.putExtra("title", news.title)
    intent.putExtra("content",news.text)
    intent.putExtra("url", news.url)
    v.context.startActivity(intent)
})
```
---
## NewsDetail
- 기사 제목, 기사 요약본
  - 데이터수집(뉴스 title, newsUrl, fulltext DB화)
  - 서버에서 요약모델 받아와 response.body에 요약본 받기
> 서버 mapping
<img src="https://user-images.githubusercontent.com/77282190/158851614-ca42ea64-3921-4229-b8f9-c065a827d769.gif"/>
