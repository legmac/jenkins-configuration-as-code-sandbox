package se.bjurr.jenkinssandbox

public class JenkinsSandboxUtils {
  /**
  * Get ip of host machine.
  */
  public static String getHostIp(steps) {
    steps.sh(
      returnStdout: true,
      script: '''echo 10.244.3.91'''
    )
    .trim()
  }
}