package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url =" + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

//    // 의존 관계 주입 종료 후 실행
//    @Override
//    public void afterPropertiesSet() throws Exception{
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }

    // 의존 관계 주입 종료 후 실행
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

//    // 소멸 메소드
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    // 소멸 메소드
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

}
