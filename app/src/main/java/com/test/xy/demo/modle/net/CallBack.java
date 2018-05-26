//package com.test.xy.demo.modle.net;
//
//import com.google.gson.Gson;
//import com.test.xy.demo.modle.entity.BaseEntity;
//import com.test.xy.demo.utils.NetWorkUtils;
//
//import io.reactivex.Observer;
//import io.reactivex.disposables.Disposable;
//import retrofit2.HttpException;
//
///**
// * Created by yj on 2017/9/8/008.
// * 自定义网络请求的回调
// */
//
//public abstract class CallBack<I> implements Observer<BaseEntity<I>> {
//
//    @Override
//    public void onSubscribe(Disposable d) {
//
//    }
//
//    @Override
//    public void onNext(BaseEntity<I> entity) {
////        StyledDialog.dismissLoading();
//        if (entity == null) {
////            Logger.e("请求返回数据为空");
//            return;
//        }
//        if (entity.getStatus() == null) {
//            return;
//        }
//        switch (entity.getStatus()) {
//            case "1200":
//                if (entity.getData() == null) {
////                    Logger.e("请求返回数据为空");
//                } else {
//                    requestBody(entity.getData());
////                    Logger.json(new Gson().toJson(entity.getData()));
//                }
//                break;
//            case "1500":
////                ToastUtil.showToast(entity.getMessage());
//            case "1402"://登录失效，请重新登录
////                ToastUtil.showToast("登录失效，请重新登录！");
////                CommentUtils.open(RoutePath.USER_LOGIN, "exit", "exit");
////                BaseApplication.clearOtherAll(LoginActivity.class);
//                break;
//            default:
//                if (entity.getMessage() != null && !"".equals(entity.getMessage()))
////                    ToastUtil.showToast(entity.getMessage());
//                break;
//
//        }
//    }
//
//    @Override
//    public void onComplete() {
////        StyledDialog.dismissLoading();
//    }
//
//    @Override
//    public void onError(Throwable e) {
////        StyledDialog.dismissLoading();
//        if (!NetWorkUtils.isNetWorked()) {
////            error();
//            return;
//        }
//
//        if (e instanceof ResultException) {
//            String message = e.getMessage();
//            BaseEntity entity = new Gson().fromJson(message, BaseEntity.class);
//            if (entity == null) {
//                return;
//            }
//            if (entity.getStatus() == null) {
//                return;
//            }
//            switch (entity.getStatus()) {
//                case "1402":
////                    ToastUtil.showToast(entity.getMessage());
////                    CommentUtils.open(RoutePath.USER_LOGIN, "exit", "exit");
////                    BaseApplication.clearOtherAll(LoginActivity.class);
//                    break;
//                case "14021"://   5次登录失败，用户不存在
////                    ToastUtil.showToast(entity.getMessage());
////                    CommentUtils.open(RoutePath.USER_REGIST);
//                    break;
//                case "14022"://5次登陆失败，密码错误
////                    ToastUtil.showToast(entity.getMessage());
////                    CommentUtils.open(RoutePath.USER_FORGET);
//                    break;
//                case "1701"://"请先设置收款密码"
////                    initDialog();
//                    break;
//                default:
////                    ToastUtil.showToast(entity.getMessage());
//                    break;
//            }
//        } else if (e instanceof HttpException) {
//            int code = ((HttpException) e).code();
//            String message = ((HttpException) e).message();
//            switch (code) {
//                case 403:
////                    ToastUtil.showToast("登录失效，请重新登录！");
////                    CommentUtils.open(RoutePath.USER_LOGIN);
////                    BaseApplication.clearOtherAll(LoginActivity.class);
////                    Logger.e(message);
//                    break;
//                case 400:
////                    ToastUtil.showToast("客户端请求有语法错误，不能被服务器所理解");
//                    break;
//                case 401:
////                    ToastUtil.showToast("请求未经授权");
//                    break;
//                case 404:
////                    ToastUtil.showToast("请求资源不存在");
//                    break;
//                case 500:
////                    ToastUtil.showToast("服务器错误，稍后重试！");
//                    break;
//                case 503:
////                    ToastUtil.showToast("服务器当前不能处理客户端的请求，一段时间后可能恢复正常");
//                    break;
//                default:
////                    ToastUtil.showToast("系统错误，稍后重试");
////                    ToastUtil.showToast(code + message);
//                    break;
//            }
//        } else {//其他错误
////            ToastUtil.showToast("网络信号差，稍后重试！");
//        }
////        Logger.e(e.getMessage());
//    }
//    /**
//     * @param data 返回请求的数据实体
//     */
//    protected abstract void requestBody(I data);
//}
