FROM jenkins/jenkins:lts

RUN mkdir $JENKINS_HOME/casc_configs
COPY ./jenkins.yaml $JENKINS_HOME/casc_configs/jenkins.yaml
ENV CASC_JENKINS_CONFIG=$JENKINS_HOME/casc_configs

ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

# install the "ip" executable called by se.bjurr.jenkinssandbox.JenkinsSandboxUtils#getHostIp()
USER root
RUN apt-get update \
  && apt-get install -y iproute2 \
  && rm -rf /var/lib/apt/lists/*
USER jenkins

RUN install-plugins.sh \
  blueocean \
  job-dsl \
  cloudbees-folder \
  pipeline-utility-steps \
  git-changelog \
  violation-comments-to-gitlab\
  ace-editor \
  anchore-container-scanner \
  ant	\
  antisamy-markup-formatter	\
  apache-httpcomponents-client-4-api	\
  authentication-tokens	\
  authorize-project	\
  azure-ad	\
  azure-sdk	\
  backup	\
  bitbucket-build-status-notifier	\
  bootstrap4-api	\
  bootstrap5-api	\
  bouncycastle-api	\
  branch-api	\
  build-blocker-plugin	\
  caffeine-api	\
  checks-api	\
  command-launcher	\
  config-file-provider	\
  configuration-as-code	\
  credentials	\
  credentials-binding	\
  display-url-api	\
  docker-commons	\
  docker-workflow	\
  durable-task	\
  echarts-api	\
  external-monitor-job	\
  font-awesome-api \
  generic-webhook-trigger	\
  git	\
  git-client \
  git-server	\
  handlebars \
  icon-shim	\
  jackson2-api	\
  javadoc	 \
  jaxb	\
  jdk-tool	\
  jira	\
  job-import-plugin	\
  jquery-detached	\
  jquery3-api	\
  jsch	\
  junit	\
  kpp-management-plugin	\
  kubernetes	\
  kubernetes-client-api	\
  kubernetes-credentials \
  ldap	\
  lockable-resources	\
  mac	\
  mailer	\
  matrix-auth	\
  matrix-project \
  mercurial	\
  metrics \
  momentjs \
  multiple-scms	\
  nodejs	\
  Office-365-Connector \
  pam-auth	\
  pipeline-build-step	\
  pipeline-graph-analysis	\
  pipeline-input-step	\
  pipeline-milestone-step	\
  pipeline-model-api	\
  pipeline-model-declarative-agent	\
  pipeline-model-definition	\
  pipeline-model-extensions	\
  pipeline-rest-api	\
  pipeline-stage-step	\
  pipeline-stage-tags-metadata	\
  pipeline-stage-view	\
  plain-credentials	\
  plugin-util-api	\
  popper-api	\
  popper2-api	\
  promoted-builds	\
  rebuild	\
  role-strategy	\
  scm-api	\
  script-security \
  slack	\
  snakeyaml-api \
  sonar	\
  ssh-credentials \
  ssh-slaves \
  sshd \
  structs	\
  thinBackup	\
  token-macro	\
  trilead-api	\
  variant	\
  windows-slaves	\
  workflow-aggregator \
  workflow-api	\
  workflow-basic-steps	\
  workflow-cps	\
  workflow-cps-global-lib \
  workflow-durable-task-step	\
  workflow-job	\
  workflow-multibranch \
  workflow-scm-step	\
  workflow-step-api	\
  workflow-support

COPY ./jenkins-wrapper.sh /usr/local/bin/jenkins-wrapper.sh

ENTRYPOINT ["/sbin/tini", "--", "/usr/local/bin/jenkins-wrapper.sh"]