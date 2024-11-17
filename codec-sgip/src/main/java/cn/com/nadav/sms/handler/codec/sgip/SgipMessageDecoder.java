//package cn.com.nadav.sms.codec.sgip;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.ByteToMessageDecoder;
//import io.netty.util.ReferenceCountUtil;
//
//import java.util.List;
//
//public class SgipMessageDecoder extends ByteToMessageDecoder {
//
//    private SgipDecoderStateEnum currentState = SgipDecoderStateEnum.START;
//    private SgipHeader header;  // 用于存储协议头
//    private ByteBuf body;          // 用于存储消息体内容
//
//
//    @Override
//    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
//        // 根据当前状态进行不同的处理
//        switch (currentState) {
//            case START:
//                // 解析协议头部
//                decodeHeader(byteBuf);
//                break;
//            case HEADER_PARSED:
//                // 根据协议头部的内容解析消息体
//                decodeBody(byteBuf);
//                break;
//            case BODY_PARSING:
//                // 完成消息体的解析并交给后续处理
//                completeMessage(byteBuf, list);
//                break;
//            case DONE:
//                // 解析完成，什么都不做
//                break;
//            case ERROR:
//                // 错误状态，抛出异常或者清空状态
//                handleError(channelHandlerContext);
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + currentState);
//        }
//    }
//
//    private void decodeHeader(ByteBuf msg) {
//        if (msg.readableBytes() < 12) {  // 假设头部是12字节（messageLength + commandId + sequenceNumber）
//            return;  // 继续等待数据
//        }
//
//        header = new SgipHeaderImpl();
//        header.setMessageLength(msg.readInt());
//        header.setCommandId(msg.readInt());
//        header.setSequenceNumber(msg.readInt());
//
//        // 检查 header 是否解析完整
//        if (header.getMessageLength() <= 0) {
//            currentState = SgipDecoderState.ERROR;
//        } else {
//            currentState = SgipDecoderState.HEADER_PARSED;
//        }
//    }
//
//    private void decodeBody(ByteBuf msg) {
//        int bodyLength = header.getMessageLength() - 12; // 12 是头部的长度
//        if (msg.readableBytes() < bodyLength) {
//            return;  // 继续等待数据
//        }
//
//        // 提取消息体
//        body = msg.readBytes(bodyLength);
//        currentState = SgipDecoderState.BODY_PARSING;
//    }
//
//    private void completeMessage(ByteBuf msg, List<Object> out) {
//        // 创建消息体并传递给下一个处理器
//        SgipContentImpl sgipContent = new SgipContentImpl(body);
//        out.add(sgipContent);  // 将解码后的消息体交给后续处理
//        resetState();  // 解析完成后，重置状态机
//    }
//
//    private void handleError(ChannelHandlerContext ctx) {
//        // 错误处理
//        System.err.println("Error decoding SGIP message!");
//        // 可根据实际情况丢弃缓冲区数据或者清空状态
//        resetState();
//        ReferenceCountUtil.release(ctx.alloc().buffer());
//    }
//
//    private void resetState() {
//        currentState = SgipDecoderState.START;  // 重置为初始状态
//        header = null;  // 清空头部
//        body = null;    // 清空消息体
//    }
//
//}
