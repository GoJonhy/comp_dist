package rpcstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: contract.proto")
public final class ServerGrpc {

  private ServerGrpc() {}

  public static final String SERVICE_NAME = "baseservice.Server";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<rpcstubs.KeyValuePair,
      rpcstubs.Void> getWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Write",
      requestType = rpcstubs.KeyValuePair.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.KeyValuePair,
      rpcstubs.Void> getWriteMethod() {
    io.grpc.MethodDescriptor<rpcstubs.KeyValuePair, rpcstubs.Void> getWriteMethod;
    if ((getWriteMethod = ServerGrpc.getWriteMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getWriteMethod = ServerGrpc.getWriteMethod) == null) {
          ServerGrpc.getWriteMethod = getWriteMethod =
              io.grpc.MethodDescriptor.<rpcstubs.KeyValuePair, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Write"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.KeyValuePair.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("Write"))
              .build();
        }
      }
    }
    return getWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Value> getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Read",
      requestType = rpcstubs.Key.class,
      responseType = rpcstubs.Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Value> getReadMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Key, rpcstubs.Value> getReadMethod;
    if ((getReadMethod = ServerGrpc.getReadMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getReadMethod = ServerGrpc.getReadMethod) == null) {
          ServerGrpc.getReadMethod = getReadMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Key, rpcstubs.Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Key.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Value.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("Read"))
              .build();
        }
      }
    }
    return getReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Value> getReadChkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadChk",
      requestType = rpcstubs.Key.class,
      responseType = rpcstubs.Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Value> getReadChkMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Key, rpcstubs.Value> getReadChkMethod;
    if ((getReadChkMethod = ServerGrpc.getReadChkMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getReadChkMethod = ServerGrpc.getReadChkMethod) == null) {
          ServerGrpc.getReadChkMethod = getReadChkMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Key, rpcstubs.Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadChk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Key.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Value.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("ReadChk"))
              .build();
        }
      }
    }
    return getReadChkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.Void,
      rpcstubs.Void> getElectionProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ElectionProcess",
      requestType = rpcstubs.Void.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Void,
      rpcstubs.Void> getElectionProcessMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Void, rpcstubs.Void> getElectionProcessMethod;
    if ((getElectionProcessMethod = ServerGrpc.getElectionProcessMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getElectionProcessMethod = ServerGrpc.getElectionProcessMethod) == null) {
          ServerGrpc.getElectionProcessMethod = getElectionProcessMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Void, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ElectionProcess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("ElectionProcess"))
              .build();
        }
      }
    }
    return getElectionProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.MonitorObj,
      rpcstubs.Void> getStopSelfElectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopSelfElection",
      requestType = rpcstubs.MonitorObj.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.MonitorObj,
      rpcstubs.Void> getStopSelfElectionMethod() {
    io.grpc.MethodDescriptor<rpcstubs.MonitorObj, rpcstubs.Void> getStopSelfElectionMethod;
    if ((getStopSelfElectionMethod = ServerGrpc.getStopSelfElectionMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getStopSelfElectionMethod = ServerGrpc.getStopSelfElectionMethod) == null) {
          ServerGrpc.getStopSelfElectionMethod = getStopSelfElectionMethod =
              io.grpc.MethodDescriptor.<rpcstubs.MonitorObj, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopSelfElection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.MonitorObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("StopSelfElection"))
              .build();
        }
      }
    }
    return getStopSelfElectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Void> getInvalidateReplicasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InvalidateReplicas",
      requestType = rpcstubs.Key.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Void> getInvalidateReplicasMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Key, rpcstubs.Void> getInvalidateReplicasMethod;
    if ((getInvalidateReplicasMethod = ServerGrpc.getInvalidateReplicasMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getInvalidateReplicasMethod = ServerGrpc.getInvalidateReplicasMethod) == null) {
          ServerGrpc.getInvalidateReplicasMethod = getInvalidateReplicasMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Key, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InvalidateReplicas"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Key.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("InvalidateReplicas"))
              .build();
        }
      }
    }
    return getInvalidateReplicasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Void> getReceiveInvalidateReplicasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveInvalidateReplicas",
      requestType = rpcstubs.Key.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Key,
      rpcstubs.Void> getReceiveInvalidateReplicasMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Key, rpcstubs.Void> getReceiveInvalidateReplicasMethod;
    if ((getReceiveInvalidateReplicasMethod = ServerGrpc.getReceiveInvalidateReplicasMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getReceiveInvalidateReplicasMethod = ServerGrpc.getReceiveInvalidateReplicasMethod) == null) {
          ServerGrpc.getReceiveInvalidateReplicasMethod = getReceiveInvalidateReplicasMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Key, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveInvalidateReplicas"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Key.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("ReceiveInvalidateReplicas"))
              .build();
        }
      }
    }
    return getReceiveInvalidateReplicasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.KeyValuePair,
      rpcstubs.Void> getCreateReplicaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReplica",
      requestType = rpcstubs.KeyValuePair.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.KeyValuePair,
      rpcstubs.Void> getCreateReplicaMethod() {
    io.grpc.MethodDescriptor<rpcstubs.KeyValuePair, rpcstubs.Void> getCreateReplicaMethod;
    if ((getCreateReplicaMethod = ServerGrpc.getCreateReplicaMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getCreateReplicaMethod = ServerGrpc.getCreateReplicaMethod) == null) {
          ServerGrpc.getCreateReplicaMethod = getCreateReplicaMethod =
              io.grpc.MethodDescriptor.<rpcstubs.KeyValuePair, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReplica"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.KeyValuePair.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("CreateReplica"))
              .build();
        }
      }
    }
    return getCreateReplicaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.KeyValuePair,
      rpcstubs.Void> getReceiveCreateReplicaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveCreateReplica",
      requestType = rpcstubs.KeyValuePair.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.KeyValuePair,
      rpcstubs.Void> getReceiveCreateReplicaMethod() {
    io.grpc.MethodDescriptor<rpcstubs.KeyValuePair, rpcstubs.Void> getReceiveCreateReplicaMethod;
    if ((getReceiveCreateReplicaMethod = ServerGrpc.getReceiveCreateReplicaMethod) == null) {
      synchronized (ServerGrpc.class) {
        if ((getReceiveCreateReplicaMethod = ServerGrpc.getReceiveCreateReplicaMethod) == null) {
          ServerGrpc.getReceiveCreateReplicaMethod = getReceiveCreateReplicaMethod =
              io.grpc.MethodDescriptor.<rpcstubs.KeyValuePair, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveCreateReplica"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.KeyValuePair.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerMethodDescriptorSupplier("ReceiveCreateReplica"))
              .build();
        }
      }
    }
    return getReceiveCreateReplicaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerStub>() {
        @java.lang.Override
        public ServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerStub(channel, callOptions);
        }
      };
    return ServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerBlockingStub>() {
        @java.lang.Override
        public ServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerBlockingStub(channel, callOptions);
        }
      };
    return ServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerFutureStub>() {
        @java.lang.Override
        public ServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerFutureStub(channel, callOptions);
        }
      };
    return ServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void write(rpcstubs.KeyValuePair request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteMethod(), responseObserver);
    }

    /**
     */
    public void read(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Value> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    /**
     */
    public void readChk(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Value> responseObserver) {
      asyncUnimplementedUnaryCall(getReadChkMethod(), responseObserver);
    }

    /**
     */
    public void electionProcess(rpcstubs.Void request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getElectionProcessMethod(), responseObserver);
    }

    /**
     */
    public void stopSelfElection(rpcstubs.MonitorObj request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getStopSelfElectionMethod(), responseObserver);
    }

    /**
     */
    public void invalidateReplicas(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getInvalidateReplicasMethod(), responseObserver);
    }

    /**
     */
    public void receiveInvalidateReplicas(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getReceiveInvalidateReplicasMethod(), responseObserver);
    }

    /**
     */
    public void createReplica(rpcstubs.KeyValuePair request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReplicaMethod(), responseObserver);
    }

    /**
     */
    public void receiveCreateReplica(rpcstubs.KeyValuePair request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getReceiveCreateReplicaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWriteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.KeyValuePair,
                rpcstubs.Void>(
                  this, METHODID_WRITE)))
          .addMethod(
            getReadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Key,
                rpcstubs.Value>(
                  this, METHODID_READ)))
          .addMethod(
            getReadChkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Key,
                rpcstubs.Value>(
                  this, METHODID_READ_CHK)))
          .addMethod(
            getElectionProcessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Void,
                rpcstubs.Void>(
                  this, METHODID_ELECTION_PROCESS)))
          .addMethod(
            getStopSelfElectionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.MonitorObj,
                rpcstubs.Void>(
                  this, METHODID_STOP_SELF_ELECTION)))
          .addMethod(
            getInvalidateReplicasMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Key,
                rpcstubs.Void>(
                  this, METHODID_INVALIDATE_REPLICAS)))
          .addMethod(
            getReceiveInvalidateReplicasMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Key,
                rpcstubs.Void>(
                  this, METHODID_RECEIVE_INVALIDATE_REPLICAS)))
          .addMethod(
            getCreateReplicaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.KeyValuePair,
                rpcstubs.Void>(
                  this, METHODID_CREATE_REPLICA)))
          .addMethod(
            getReceiveCreateReplicaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.KeyValuePair,
                rpcstubs.Void>(
                  this, METHODID_RECEIVE_CREATE_REPLICA)))
          .build();
    }
  }

  /**
   */
  public static final class ServerStub extends io.grpc.stub.AbstractAsyncStub<ServerStub> {
    private ServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerStub(channel, callOptions);
    }

    /**
     */
    public void write(rpcstubs.KeyValuePair request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Value> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readChk(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Value> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadChkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void electionProcess(rpcstubs.Void request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getElectionProcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopSelfElection(rpcstubs.MonitorObj request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStopSelfElectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void invalidateReplicas(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInvalidateReplicasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveInvalidateReplicas(rpcstubs.Key request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReceiveInvalidateReplicasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createReplica(rpcstubs.KeyValuePair request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReplicaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveCreateReplica(rpcstubs.KeyValuePair request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReceiveCreateReplicaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServerBlockingStub> {
    private ServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public rpcstubs.Void write(rpcstubs.KeyValuePair request) {
      return blockingUnaryCall(
          getChannel(), getWriteMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Value read(rpcstubs.Key request) {
      return blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Value readChk(rpcstubs.Key request) {
      return blockingUnaryCall(
          getChannel(), getReadChkMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Void electionProcess(rpcstubs.Void request) {
      return blockingUnaryCall(
          getChannel(), getElectionProcessMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Void stopSelfElection(rpcstubs.MonitorObj request) {
      return blockingUnaryCall(
          getChannel(), getStopSelfElectionMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Void invalidateReplicas(rpcstubs.Key request) {
      return blockingUnaryCall(
          getChannel(), getInvalidateReplicasMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Void receiveInvalidateReplicas(rpcstubs.Key request) {
      return blockingUnaryCall(
          getChannel(), getReceiveInvalidateReplicasMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Void createReplica(rpcstubs.KeyValuePair request) {
      return blockingUnaryCall(
          getChannel(), getCreateReplicaMethod(), getCallOptions(), request);
    }

    /**
     */
    public rpcstubs.Void receiveCreateReplica(rpcstubs.KeyValuePair request) {
      return blockingUnaryCall(
          getChannel(), getReceiveCreateReplicaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServerFutureStub extends io.grpc.stub.AbstractFutureStub<ServerFutureStub> {
    private ServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> write(
        rpcstubs.KeyValuePair request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Value> read(
        rpcstubs.Key request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Value> readChk(
        rpcstubs.Key request) {
      return futureUnaryCall(
          getChannel().newCall(getReadChkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> electionProcess(
        rpcstubs.Void request) {
      return futureUnaryCall(
          getChannel().newCall(getElectionProcessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> stopSelfElection(
        rpcstubs.MonitorObj request) {
      return futureUnaryCall(
          getChannel().newCall(getStopSelfElectionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> invalidateReplicas(
        rpcstubs.Key request) {
      return futureUnaryCall(
          getChannel().newCall(getInvalidateReplicasMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> receiveInvalidateReplicas(
        rpcstubs.Key request) {
      return futureUnaryCall(
          getChannel().newCall(getReceiveInvalidateReplicasMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> createReplica(
        rpcstubs.KeyValuePair request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReplicaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> receiveCreateReplica(
        rpcstubs.KeyValuePair request) {
      return futureUnaryCall(
          getChannel().newCall(getReceiveCreateReplicaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRITE = 0;
  private static final int METHODID_READ = 1;
  private static final int METHODID_READ_CHK = 2;
  private static final int METHODID_ELECTION_PROCESS = 3;
  private static final int METHODID_STOP_SELF_ELECTION = 4;
  private static final int METHODID_INVALIDATE_REPLICAS = 5;
  private static final int METHODID_RECEIVE_INVALIDATE_REPLICAS = 6;
  private static final int METHODID_CREATE_REPLICA = 7;
  private static final int METHODID_RECEIVE_CREATE_REPLICA = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE:
          serviceImpl.write((rpcstubs.KeyValuePair) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((rpcstubs.Key) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Value>) responseObserver);
          break;
        case METHODID_READ_CHK:
          serviceImpl.readChk((rpcstubs.Key) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Value>) responseObserver);
          break;
        case METHODID_ELECTION_PROCESS:
          serviceImpl.electionProcess((rpcstubs.Void) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        case METHODID_STOP_SELF_ELECTION:
          serviceImpl.stopSelfElection((rpcstubs.MonitorObj) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        case METHODID_INVALIDATE_REPLICAS:
          serviceImpl.invalidateReplicas((rpcstubs.Key) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        case METHODID_RECEIVE_INVALIDATE_REPLICAS:
          serviceImpl.receiveInvalidateReplicas((rpcstubs.Key) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        case METHODID_CREATE_REPLICA:
          serviceImpl.createReplica((rpcstubs.KeyValuePair) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        case METHODID_RECEIVE_CREATE_REPLICA:
          serviceImpl.receiveCreateReplica((rpcstubs.KeyValuePair) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rpcstubs.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Server");
    }
  }

  private static final class ServerFileDescriptorSupplier
      extends ServerBaseDescriptorSupplier {
    ServerFileDescriptorSupplier() {}
  }

  private static final class ServerMethodDescriptorSupplier
      extends ServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerFileDescriptorSupplier())
              .addMethod(getWriteMethod())
              .addMethod(getReadMethod())
              .addMethod(getReadChkMethod())
              .addMethod(getElectionProcessMethod())
              .addMethod(getStopSelfElectionMethod())
              .addMethod(getInvalidateReplicasMethod())
              .addMethod(getReceiveInvalidateReplicasMethod())
              .addMethod(getCreateReplicaMethod())
              .addMethod(getReceiveCreateReplicaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
