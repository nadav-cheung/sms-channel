package cn.com.nadav.sms.handler.codec.sgip.utils;

import io.netty.channel.Channel;

import java.net.InetSocketAddress;

public class ChannelInfoUtil {

    /**
     * Create a name for the channel based on the remote host's IP and port.
     */
    static public String createChannelName(Channel channel) {
        // check if anything is null
        if (channel == null || channel.remoteAddress() == null) {
            return "ChannelWasNull";
        }
        // create a channel name
        if (channel.remoteAddress() instanceof InetSocketAddress) {
            InetSocketAddress addr = (InetSocketAddress) channel.remoteAddress();
            // just get the raw IP address
            String remoteHostAddr = addr.getAddress().getHostAddress();
            int remoteHostPort = addr.getPort();
            return remoteHostAddr + ":" + remoteHostPort;
        } else {
            return channel.remoteAddress().toString();
        }
    }

    static public String getChannelRemoteHost(Channel channel) {
        if (channel == null || channel.remoteAddress() == null) {
            return null;
        }
        // create a channel name
        if (channel.remoteAddress() instanceof InetSocketAddress) {
            InetSocketAddress addr = (InetSocketAddress) channel.remoteAddress();
            // just get the raw IP address
            return addr.getAddress().getHostAddress();
        }
        return null;
    }

    static public int getChannelRemotePort(Channel channel) {
        if (channel == null || channel.remoteAddress() == null) {
            return 0;
        }
        // create a channel name
        if (channel.remoteAddress() instanceof InetSocketAddress) {
            InetSocketAddress addr = (InetSocketAddress) channel.remoteAddress();
            // just get the raw IP address
            return addr.getPort();
        }
        return 0;
    }


}
